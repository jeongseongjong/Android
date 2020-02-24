package com.biz.memo.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.biz.memo.domain.MemoVO;

import java.util.List;

@Dao
public interface MemoDao {

    /*
        LiveData
        Android의 room DB와 연동하여
        MVVM패턴을 사용할 수 있도록 도와주는 Helper class
        lifeCycle의 포함된 클래스로서 DB내용이 변경되면
        변경된 부분만 가져와서 view에 표시할 수 있도록
        알람을 내부적으로 발생시키는 클래스
     */

    @Query("SELECT rowid, m_date, m_time, m_text FROM tbl_memo")
    public LiveData<List<MemoVO>> selectAll();

    // @SELECT 대신 @Query사용
    // WHERE rowid = #{rowid} 대신 :rowid 사용
    @Query("SELECT rowid, m_date, m_time, m_text FROM tbl_memo WHERE rowid = :rowid")
    public MemoVO findByRowId(int rowid);

    @Query("SELECT rowid, m_date, m_time, m_text FROM tbl_memo WHERE m_text LIKE :m_text")
    public LiveData<List<MemoVO>> findByText(String m_text);


    /*
        ORM 구조에서는 새로운 데이터는 insert를 수행하고
        기존 데이터는 replace를 수행하는 메소드를 공통으로 사용한다.
     */
    // onConflict는 값(어떤 값이 들어갈지 모르는 변수)
    // OnConflictStarategy.REPLACE : Insert와 Update를 같이 사용할 수 있다.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void save(MemoVO memoVO);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(MemoVO memoVO);

    @Update
    public void update(MemoVO memoVO);

    /*
        표준 room @Delete method는
        vo를 매개변수로 받아서 delete를 수행
     */
    @Delete
    public void delete(MemoVO memoVO);

    @Query("DELETE FROM tbl_memo WHERE rowid = :rowid")
    public void delete(int rowid);


}
