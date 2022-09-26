package com.example.springbootdemoapp.rest;

import com.example.springbootdemoapp.entity.Room;
import com.example.springbootdemoapp.entity.User;
import com.example.springbootdemoapp.service.RoomService;
import com.example.springbootdemoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private RoomService roomService;
    private UserService userService;

    int id;

    @Autowired
    public MainController(RoomService theRoomService,UserService theUserService)
    {
        roomService=theRoomService;
        userService=theUserService;
    }

    @PostMapping("/addRooms")
    public Room addRoom(@RequestBody Room theRoom)
    {
        theRoom.setId(0);
        roomService.save(theRoom);
        return theRoom;
    }

    @PostMapping("/addUsers")
    public User addUser(@RequestBody User theuser)
    {
        theuser.setId(0);
        userService.save(theuser);
        return theuser;
    }

    @GetMapping("/users/{userName}/{password}")
    public String loginStatus(@PathVariable String userName,@PathVariable String password)
    {
        id=userService.loginStatus(userName,password);
        if(id==0)
        {
          return "Invalid username and password";
        }
      return "User Login successfully";
    }

    @GetMapping("/rooms")
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @GetMapping("/bookRooms/{roomNo}/{fromDate}/{toDate}")
    public String bookRooms(@PathVariable int roomNo,@PathVariable String fromDate,@PathVariable String toDate)
    {
        if(roomService.bookroom(roomNo,fromDate,toDate)) {
           if(roomService.updateStatus(roomNo,fromDate,toDate,id))
           {return "Room is available";}
        }
            return "Room is not available in that dates";
    }

    @GetMapping("/cancelRoom/{roomNo}")
    public String cancelbooking(@PathVariable int roomNo)
    {

        if(roomService.cancelbooking(roomNo))
            return "Your booking is cancelled";

        return "Unable to cancel the booking";

    }







}
