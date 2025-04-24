db = db.getSiblingDB('asignaturasdb');

db.createCollection('asignaturas');
db.asignaturas.insertMany([
  {
    "_id": ObjectId("67f93a561aa33559fd996f76"),
    "nombre": "Matemáticas",
    "descripcion": "Curso de Matemáticas"
  },
  {
    "_id": ObjectId("67f93a7a1aa33559fd996f78"),
    "nombre": "Física",
    "descripcion": "Curso de Matemáticas"
  },
  {
    "_id": ObjectId("67f9cb9e30bb727decfe304a"),
    "nombre": "Álgebra",
    "descripcion": "Curso de Álgebra",
    "_class": "com.example.asignaturas.model.Asignatura"
  },
  {
    "_id": ObjectId("67f9d12a3e4a0a4b985891ef"),
    "nombre": "Informática",
    "descripcion": "Curso de Informática",
    "_class": "com.example.asignaturas.model.Asignatura"
  },
  {
    "_id": ObjectId("67f9f5413c4c98748c80b132"),
    "nombre": "Naturales",
    "descripcion": "Curso de naturales",
    "_class": "com.example.asignaturas.model.Asignatura"
  },
  {
    "_id": ObjectId("68096e42f515f114189f36ee"),
    "nombre": "DEV",
    "descripcion": "IT",
    "_class": "com.example.asignaturas.model.Asignatura"
  }
]);