FROM postgres
ENV POSTGRES_USER chronos
ENV POSTGRES_PASSWORD password
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432