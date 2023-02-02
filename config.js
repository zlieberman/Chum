process.on('unhandledRejection', (reason, promise) => {
  console.error('Unhandled Rejection at:', reason.stack || reason)
})


const MongoClient = require('mongodb').MongoClient;
const bcrypt = require('bcrypt');

const saltRounds = 10;

// Connection URL
const url = 'mongodb://localhost:27017';

// Database Name
const dbName = 'chumdb';

// Use connect method to connect to the server
MongoClient.connect(url, { useUnifiedTopology: true }, function(err, client) {
  console.log("Connected successfully to server");
  
  const db = client.db(dbName);
  
  bcrypt.hash("rootpass", saltRounds, function(err, hash) {
    // Store hash in your password DB.
    db.createUser({
      user: "rootuser",
      pwd: hash,
      roles: [{ role: "readWrite", db: "chumdb" }]
    });
    
    client.close();
  });
});
