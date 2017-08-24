package com.isuno2.realmdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.isuno2.realmdemo.bean.Student;
import com.isuno2.realmdemo.bean.Teacher;
import com.isuno2.realmdemo.dao.DaoManager;
import com.isuno2.realmdemo.dao.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * 语文老师
     */
    private static final long CH_TEACHER = 1;
    /**
     * 数学老师
     */
    private static final int MT_TEACHER = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        threaInset();
    }

    private void threaInset(){
        insert();
    }


    private void insert(){
        Teacher teacher = new Teacher();
        teacher.setProgram("语文");
        teacher.setTeacherId(CH_TEACHER);

        long id = DaoManager.getInstance().getDaoSession().getTeacherDao().insertOrReplace(teacher);
        Log.d(TAG, "insert: ===========================>>>>>>>>>>" + id);
        Log.d(TAG, "insert: " + System.currentTimeMillis());
        ArrayList<Student> students = new ArrayList<>();
        for(int i=0;i<100;i++){
            Student student =  new Student();
            student.setName("张三"+i);
            student.setWaiId(CH_TEACHER);
            student.setStockType("10010"+i);
            student.setCode("1000"+i);
            students.add(student);
        }
        DaoManager.getInstance().getDaoSession().getStudentDao().insertOrReplaceInTx(students);
        Log.d(TAG, "insert: " + System.currentTimeMillis());
        limt(2,5);
    }

    private void limt(int limit,int count){
        List<Student> list = DaoManager.getInstance().getDaoSession().getStudentDao().queryBuilder()
                .where(StudentDao.Properties.WaiId.eq(CH_TEACHER))
                .offset(limit*count)
                .limit(count).list();
        for(Student student:list){
            Log.d(TAG, "insert: " + student.toString());
        }
    }

}
