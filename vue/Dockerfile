## Building stage
FROM node:15.10.0-alpine3.13 AS builder
WORKDIR /src/

# cache dependencies
COPY package*.json /src/
RUN npm install

# build source
COPY . /src/
RUN npm run build --prod --output-path=./dist

RUN ls -R /src/dist

## Final image
FROM nginx:1.19.7-alpine
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /src/docker/nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /src/dist/ /usr/share/nginx/html
COPY --from=builder /src/docker/settings.template.json /usr/share/nginx/html/assets/

# create settings.json file based on environment variables on startup
CMD ["/bin/sh",  "-c",  "envsubst < /usr/share/nginx/html/assets/settings.template.json > /usr/share/nginx/html/assets/settings.json && exec nginx -g 'daemon off;'"]