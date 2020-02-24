package com.biz.memo.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.biz.memo.db.MemoDataBase;
import com.biz.memo.domain.MemoVO;

import java.util.List;

/*
    하는일
    DB 접근할 때 사용할 Service클래스
 */
public class MemoRepository {

    private MemoDao mDao;

    public MemoRepository(Application application) {

        MemoDataBase db = MemoDataBase.getInstance(application);
        mDao = db.getMemoDao();
    }

    public LiveData<List<MemoVO>> selectAll(){

        return mDao.selectAll();
    }

    /* thread로 insert 실행 */
    public void insert(final MemoVO memoVO) {
/*
        MemoDataBase.dbWriterThread.execute(new Runnable() {
            @Override
            public void run() {
                mDao.save(memoVO);
            }
        });
*/

         //   람다형식
            MemoDataBase.dbWriterThread.execute(()->{
                mDao.save(memoVO);
            });

    }

    public void delete(MemoVO memoVO) {

        MemoDataBase.dbWriterThread.execute(() -> mDao.delete(memoVO));

    }
}
