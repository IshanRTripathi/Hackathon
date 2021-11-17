package com.hackathon.hackathon.leaveManagement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface LeaveRepository extends JpaRepository<LeaveEntity, UUID> {

    List<LeaveEntity> findByEmployeeId(String employeeId);
}
