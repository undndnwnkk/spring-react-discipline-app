#!/bin/bash
# Ждем, пока Vault поднимется
sleep 5

# Авторизуемся и включаем движок (если еще не включен)
docker exec vault vault login undndnwnkk-discipline-super-app
docker exec vault vault secrets enable -path=secret kv-v2

# Заливаем твои секреты
docker exec vault vault kv put secret/userservice \
  spring.datasource.url="jdbc:postgresql://userservice-db:5432/discipline_db" \
  spring.datasource.username="admin" \
  spring.datasource.password="superpassword"

echo "Vault initialized!"