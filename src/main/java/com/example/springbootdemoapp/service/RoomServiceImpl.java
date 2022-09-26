package com.example.springbootdemoapp.service;

import com.example.springbootdemoapp.dao.RoomRepository;
import com.example.springbootdemoapp.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository theroomRepository)
    {
        roomRepository=theroomRepository;
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public boolean bookroom(int roomNo, String fromDate, String toDate)  {
        String roomStatus=roomRepository.bookRoom(roomNo);
        if(roomStatus.equals("available")){
           return true;
        }
        return false;
    }

    @Override
    public boolean updateStatus(int roomNo, String fromDate, String toDate,int id) {

        int isAvailable = roomRepository.updateStatus(roomNo,fromDate,toDate,id);
        if(isAvailable>0)
            return true;

        return false;
    }

    @Override
    public boolean cancelbooking(int roomNo)
    {
        int cancellationStatus = roomRepository.cancelStatus(roomNo);
        if(cancellationStatus>0)
            return true;

        return false;

    }


}
