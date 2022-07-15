package kr.ac.kopo.ctc.spring.board.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;
import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Repository
public interface BoardGroupRepository extends JpaRepository<BoardGroup, Integer>, JpaSpecificationExecutor<BoardGroup>, PagingAndSortingRepository<BoardGroup, Integer> {
}
