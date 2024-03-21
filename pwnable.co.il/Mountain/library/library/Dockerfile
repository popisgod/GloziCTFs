# sudo docker build -t library .
# sudo docker run -d -p 9010:1024 --rm -it library

FROM ubuntu:20.04

RUN apt-get update

RUN useradd -d /home/library/ -m -p library -s /bin/bash library
RUN echo "library:library" | chpasswd

WORKDIR /home/library

COPY library .
COPY flag .
COPY ynetd .

USER library
EXPOSE 1024
CMD ./ynetd -p 1024 ./library
