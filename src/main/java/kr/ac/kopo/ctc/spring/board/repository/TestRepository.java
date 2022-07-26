package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>, JpaSpecificationExecutor<Test>{

}
