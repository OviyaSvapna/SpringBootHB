package com.example.springbootdemoapp.dao;

import com.example.springbootdemoapp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RoomRepository extends JpaRepository<Room,Integer>
{

    @Query("select status from Room where roomNo = :roomNo")
    String bookRoom(@Param("roomNo")int roomNo);

    @Modifying
    @Transactional
    @Query("UPDATE Room set fromDate = :fromDate,toDate = :toDate,status ='occupied',userid = :id where roomNo = :roomNo")
    int updateStatus(@Param("roomNo") int roomNo, @Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE Room set fromDate = null,toDate = null,status ='available',userid = null where roomNo = :roomNo")
    int cancelStatus(@Param("roomNo")int roomNo);
}
