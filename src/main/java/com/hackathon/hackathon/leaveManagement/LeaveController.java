package com.hackathon.hackathon.leaveManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applyLeave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/getAvailableLeaves/{employeeId}")
    public ResponseEntity<?> getAvailableLeaves(@PathVariable("employeeId") String employeeId){
        return ResponseEntity.ok(leaveService.getAvailableLeaves(employeeId));
    }

    @PostMapping("")
    public ResponseEntity<?> requestForLeave(@RequestBody LeaveRequest leaveRequest){
        return ResponseEntity.ok(leaveService.processLeave(leaveRequest));
    }
}
