package com.hackathon.hackathon.leaveManagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {
    String leaveType;
    String fromDate;
    String toDate;
    String reason;
    String employeeId;
}
