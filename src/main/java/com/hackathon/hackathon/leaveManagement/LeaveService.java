package com.hackathon.hackathon.leaveManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveService {

    @Autowired
    LeaveRepository leaveRepository;

    public List<LeaveEntity> getAvailableLeaves(String employeeId) {
        List<LeaveEntity> leaves = leaveRepository.findByEmployeeId(employeeId);
        if(leaves==null || leaves.size()==0){
            leaveRepository.saveAll(getLeaveInfo(employeeId));
        }
        leaves = leaveRepository.findByEmployeeId(employeeId);
        return leaves;
    }

    private List<LeaveEntity> getLeaveInfo(String employeeId) {
        return List.of(LeaveEntity.builder()
                .balance(5)
                .leaveType("sick")
                .employeeId(employeeId)
                .build(),
            LeaveEntity.builder()
                .balance(10)
                .leaveType("casual")
                .employeeId(employeeId)
                .build(),
            LeaveEntity.builder()
                .balance(5)
                .leaveType("bereavement")
                .employeeId(employeeId)
                .build()
            );
    }

    public String processLeave(LeaveRequest leaveRequest) {
        String employeeId = leaveRequest.getEmployeeId();
        List<LeaveEntity> availableLeaves = leaveRepository.findByEmployeeId(employeeId);
        for(LeaveEntity leaveEntity : availableLeaves) {
            if(leaveEntity.getLeaveType().equals(leaveRequest.getLeaveType())){
//                if(leaveEntity.getBalance()<leaveRequest.ge)
//                updateLeaveBalance(employeeId, )
            }
        }
        return "processed";
    }
}
