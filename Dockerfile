FROM java:8

RUN agt-get update && apt-get install -yes git  \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /var/www/html/themes

RUN git clone https://github.com/zaghir/eshopper-api-avion.git

