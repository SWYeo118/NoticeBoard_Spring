package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.dto.Pagination;

@Repository
public interface PaginationService {
	Pagination getPagination(int currentPage, int countPerPage, int pageSize, int totalCount);
}
