# sudo docker build -t mipsverse-v1 .
# sudo docker run -d -p 9020:1024 --rm -it mipsverse-v1

FROM ubuntu:22.04

RUN apt-get update

RUN useradd -d /home/mipsverse/ -m -p mipsverse -s /bin/bash mipsverse
RUN echo "mipsverse:mipsverse" | chpasswd

WORKDIR /home/mipsverse

COPY MIPSverse .
COPY flag .
COPY ynetd .

USER mipsverse
EXPOSE 1024
CMD ["./ynetd", "-p", "1024", "./MIPSverse"]
