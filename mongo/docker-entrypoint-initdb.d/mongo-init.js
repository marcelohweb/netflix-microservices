print('START');

db = db.getSiblingDB('db_netflix_app_user');
db.createUser(
  {
    user: 'user',
    pwd: 'password',
    roles: [{ role: 'readWrite', db: 'db_netflix_app_user' }],
  },
);
db.createCollection('user');

print('END');
