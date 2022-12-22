var express = require('express');
var router = express.Router();

// con = mysql에 접속할수있다.

const mysql = require('mysql');
const connection = mysql.createConnection({
    host: 'localhost',
    port: '3306',
    user: 'root',
    password: '1234',
    database: 'db01',
});
connection.connect();

router.get('/list', function (req, res, next) {

    connection.query("SELECT * from test", (error, rows, fields) => {
        if (error) throw error;
        console.log(rows);
        res.send(rows);
    });

});
router.post('/add', function (req, res, next) {
    connection.query("INSERT INTO test (id, name, password) values (?, ?, ?);",
        [null, req.body.name, req.body.password],
        (error, rows, fields) => {
            if (error) throw error;
        });
});
router.post('/update', function (req, res, next) {
    connection.query("UPDATE test SET password=? where name=?;",
        [req.body.password, req.body.name],
        (error, rows, fields) => {
            if (error) throw error;
        });
});
router.post('/delete', function (req, res, next) {
    connection.query("DELETE FROM test where name=?;",
        [req.body.name],
        (error, rows, fields) => {
            if (error) throw error;
        });
});

module.exports = router;