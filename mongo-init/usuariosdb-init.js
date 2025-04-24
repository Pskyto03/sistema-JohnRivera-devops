db = db.getSiblingDB('usuariosdb');

db.createCollection('usuarios');
db.usuarios.insertMany([
  {
    "_id": ObjectId("67f93a141aa33559fd996f6f"),
    "nombre": "Juan",
    "rol": "Estudiante"
  },
  {
    "_id": ObjectId("67f93a331aa33559fd996f71"),
    "nombre": "Pablo",
    "rol": "Estudiante"
  },
  {
    "_id": ObjectId("67f93a411aa33559fd996f73"),
    "nombre": "Montoya",
    "rol": "Estudiante"
  },
  {
    "_id": ObjectId("67f93b4d1aa33559fd996f81"),
    "nombre": "David",
    "rol": "Docente"
  },
  {
    "_id": ObjectId("67f93b561aa33559fd996f83"),
    "nombre": "Manuel",
    "rol": "Docente"
  },
  {
    "_id": ObjectId("67f93b5f1aa33559fd996f85"),
    "nombre": "Clarita",
    "rol": "Docente"
  },
  {
    "_id": ObjectId("67f9cd76c9e18e720ebaf3ef"),
    "nombre": "Maria",
    "rol": "Docente",
    "_class": "com.example.usuarios.model.Usuario"
  },
  {
    "_id": ObjectId("67f9d0f16bb458396deeb487"),
    "nombre": "Juana",
    "rol": "Docente",
    "_class": "com.example.usuarios.model.Usuario"
  },
  {
    "_id": ObjectId("680965b300d0010b3180efb8"),
    "nombre": "Ana López",
    "username": "analopez",
    "password": "$2a$10$GKeQlcDQNAykRAbKbV1pueeZFMNE6eSrtCZULZxiREL/QeH7IAqzm",
    "rol": "Docente",
    "_class": "com.example.usuarios.model.Usuario"
  },
  {
    "_id": ObjectId("68096a0200d0010b3180efbb"),
    "nombre": "Admin",
    "username": "admin",
    "password": "$2a$10$3jvp.qc/9OGu25EvCIKrgum0jy0yT8DuccnjdVK6n8qSZPOAgXV86",
    "rol": "ADMIN",
    "_class": "com.example.usuarios.model.Usuario"
  },
  {
    "_id": ObjectId("68097187b4e9cf4d488e897c"),
    "nombre": "John Rivera",
    "username": "jarr",
    "password": "$2a$10$uumIFn3L5WrjlGJlg0Qj8uWSMCPr1vRSrSiMuEwiQm8rx87XZ8VoS",
    "rol": "ADMIN",
    "_class": "com.example.usuarios.model.Usuario"
  },
  {
    "_id": ObjectId("680a8b5265b378158a608cb9"),
    "nombre": "John Rivera 1",
    "username": "jarr1",
    "password": "$2a$10$PdZ.hTh77o3IFy.Kv74pKOsmzKbdm6NtEhTKq8DB9WgVgC2U357ye",
    "rol": "ADMIN",
    "_class": "com.example.usuarios.model.Usuario"
  }
]);