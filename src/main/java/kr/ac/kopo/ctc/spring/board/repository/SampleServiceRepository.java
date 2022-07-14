package kr.ac.kopo.ctc.spring.board.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.Sample;

@Repository
public interface SampleServiceRepository extends JpaRepository<Sample, Integer>, JpaSpecificationExecutor<Sample>, PagingAndSortingRepository<Sample, Integer> {
}
