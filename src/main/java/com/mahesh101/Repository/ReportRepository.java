package com.mahesh101.Repository;

import com.mahesh101.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository  extends JpaRepository<Report,Long> {
}
