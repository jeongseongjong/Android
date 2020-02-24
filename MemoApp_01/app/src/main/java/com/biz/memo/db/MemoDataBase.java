package com.biz.memo.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.biz.memo.domain.MemoVO;
import com.biz.memo.repository.MemoDao;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// entities로 설정되어 있는 class를 임의로 설정을 하겠다.
@Database(entities = {MemoVO.class},version = 2, exportSchema = false)
abstract public class MemoDataBase extends RoomDatabase {

    /*
        데이터베이스 INSTANCE가 생성이 되면서
        MemoDao interface를 가져다가 사용할 수 있는 class 생성을 한다.
     */
    abstract public MemoDao getMemoDao();

    // 고전적인 Thread 클래스를 도와서 Thread를 관리해주는
    // Helper 클래스
    // 앞으로 실행항(생성할) Thread를 위한 Context정보를 담을 객체를
    // 미리 비어있는 상태로 생성을 해두고 필요할 때 공급하는 용도
    public static final ExecutorService dbWriterThread
            = Executors.newFixedThreadPool(3);

    /*
        DataBase를 생성하는 클래스를 싱글톤으로 선언하기 위해
        외부에서 접근하는 변수 선언
     */
    private static volatile MemoDataBase INSTANCE;
    public static MemoDataBase getInstance(final Context context){

        // INSTANCE : db연결 connection
        if(INSTANCE == null){

            // MemoDataBase를 싱글톤으로 선언한다.
            synchronized (MemoDataBase.class){

                INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        MemoDataBase.class,

                        // 위의 클래스를 이용해서 memo.dbf 라는
                        // DataBase file을 만들어라
                        "memo.dbf").build();
            }
        }
        return INSTANCE;
    }


}
