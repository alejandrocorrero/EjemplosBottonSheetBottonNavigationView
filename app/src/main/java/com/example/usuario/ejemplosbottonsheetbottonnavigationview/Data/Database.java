package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data;

import com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model.Student;

public class Database {

    private static Database instance;

    private Student student;

    private Database() {

        student= new Student("Baldomero","66666666","https://qzprod.files.wordpress.com/2018/01/falon-heavy-elon-musk-spacex-rocket-static-fire-spacex.jpg?quality=80&strip=all&w=2400");

    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
