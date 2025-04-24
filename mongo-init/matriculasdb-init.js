db = db.getSiblingDB('matriculasdb');

db.createCollection('matriculas');
db.matriculas.insertMany([
  {
    "_id": ObjectId("67f93a9f1aa33559fd996f7c"),
    "idEstudiante": "67f93a141aa33559fd996f6f",
    "idAsignatura": "67f93a561aa33559fd996f76"
  },
  {
    "_id": ObjectId("67f9e1c8d855a56075282e02"),
    "idEstudiante": "67f93a141aa33559fd996f6f",
    "idAsignatura": "67f93a561aa33559fd996f76",
    "_class": "com.example.matriculas.model.Matricula"
  },
  {
    "_id": ObjectId("67fa727727bddd450ead986b"),
    "idEstudiante": "67f93a141aa33559fd996f6f",
    "idAsignatura": "67f93a561aa33559fd996f76",
    "_class": "com.example.matriculas.model.Matricula"
  }
]);