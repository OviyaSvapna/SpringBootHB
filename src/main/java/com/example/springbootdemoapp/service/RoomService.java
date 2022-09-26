package com.example.springbootdemoapp.service;

import com.example.springbootdemoapp.entity.Room;

import java.util.List;

public interface RoomService
{
    public void save(Room room);
    public List<Room> findAll();
    public boolean bookroom(int roomno,String fromDate,String toDate);
    public boolean updateStatus(int roomNo, String fromDate, String toDate,int userid);
    public boolean cancelbooking(int roomNo);
}
