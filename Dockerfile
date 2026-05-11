FROM ubuntu:24.04@sha256:186072bba1b2f436cbb91ef2567abca677337cfc786c86e107d25b7072feef0c

SHELL ["/bin/bash", "-c"]
WORKDIR "/root"

# Install asdf plugin dependencies
RUN apt-get update \
  && DEBIAN_FRONTEND=noninteractive TZ=Etc/UTC apt-get install -y curl git zip unzip build-essential libssl-dev zlib1g-dev libbz2-dev libreadline-dev libsqlite3-dev libncursesw5-dev xz-utils tk-dev libxml2-dev libxmlsec1-dev libffi-dev liblzma-dev \
  && rm -rf /var/lib/apt/lists/*

# Copy asdf tool versions
COPY .tool-versions .tool-versions

# Install asdf
RUN git clone https://github.com/asdf-vm/asdf.git .asdf/ --branch v0.14.0

# Install asdf plugins and awscurl
RUN source .asdf/asdf.sh \
  && asdf plugin add java https://github.com/halcyon/asdf-java.git \
  && asdf plugin-add gradle https://github.com/rfrancis/asdf-gradle.git \
  && asdf install

ENV PATH="/root/.asdf/shims:/root/.asdf/bin:$PATH"

# Copy build files
COPY settings.gradle settings.gradle
COPY build.gradle build.gradle

# Copy source
COPY src src

# Build the jar
RUN gradle bootJar

CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]