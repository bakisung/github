<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../include/nav.jsp" %>

	<!-- Main Start -->
	<main>
		<section class="py-5 text-center container" style="margin-top: 3em;">
		
			<div class="card mb-3 mb-lg-5">
				<div class="card border-0 flex-fill w-100" data-list="{&quot;valueNames&quot;: [&quot;name&quot;, &quot;email&quot;, &quot;id&quot;, {&quot;name&quot;: &quot;date&quot;, &quot;attr&quot;: &quot;data-signed&quot;}, &quot;status&quot;], &quot;page&quot;: 8}" id="users">

					<div class="card-header" style="background-color: white">
			          <div class="row justify-content-between align-items-center flex-grow-1">
			            <div class="col-md">
			              <div class="d-flex justify-content-between align-items-center">
			                <h4 class="card-header-title">게시판</h4>
			
			                <!-- Datatable Info -->
			                <div id="datatableCounterInfo" style="display: none;">
			                  <div class="d-flex align-items-center">
			                    <span class="fs-6 me-3">
			                      <span id="datatableCounter">0</span>
			                      Selected
			                    </span>
			                    <a class="btn btn-outline-danger btn-sm" href="javascript:;">
			                      <i class="tio-delete-outlined"></i> Delete
			                    </a>
			                  </div>
			                </div>
			                <!-- End Datatable Info -->
			              </div>
			            </div>
			            <!-- End Col -->
			
			            <div class="col-auto">
			              <!-- Filter -->
			              <div class="row align-items-sm-center">
			                <div class="col-sm-auto">
			                  <div class="row align-items-center gx-0">
			                    <div class="col">
			                      <span class="text-secondary me-2">Keyword:</span>
			                    </div>
			
			                    <div class="col-auto">
									<div class="tom-select-custom tom-select-custom-end">
										<select class="form-control col-md-2 custom-select" name="searchType" id="searchType" style="font-size: 0.8em;">
												<option value="ne" ${cri.searchType eq 'ne' ? 'selected' : '' }>코드번호 + 담당자</option>
												<option value="n" ${cri.searchType eq 'n' ? 'selected' : '' }>코드번호</option>
												<option value="e" ${cri.searchType eq 'e' ? 'selected' : '' }>담당자</option>
										</select>
			                      	</div>
			                    </div>
			                  </div>
			                </div>
			
			                <div class="col-md">
			                  <form>
			                    <!-- Search -->
			                    <div class="input-group input-group-merge input-group-flush">
			                      <div class="input-group-prepend input-group-text">
			                        <i class="bi-search"></i>
			                      </div>
			                      <input id="datatableSearch" type="search" class="form-control" placeholder="Search" aria-label="Search">
			                    </div>
			                    <!-- End Search -->
			                  </form>
			                </div>
			                
			                <div class="col-md">
				                <button class="btn btn-success" id="registFormBtn">등록</button>
				                <button class="btn btn-danger" id="deleteBtn">삭제</button>
			                </div>
			
			                <!-- End Col -->
			              </div>
			              <!-- End Filter -->
			            </div>
			            <!-- End Col -->
			          </div>
			          <!-- End Row -->
			        </div>
	
					<!-- Table -->
					<div class="table-responsive">
					    <table class="table align-middle table-edge table-hover table-nowrap mb-0">
					        <thead class="thead-light">
					            <tr>
					                <th class="w-60px">
					                    <div class="form-check mb-0">
					                        <input class="form-check-input" type="checkbox" value="" id="checkAllCheckboxes">
					                    </div>
					                </th>
					                <th>
					                    <a href="javascript: void(0);" class="text-muted list-sort" data-sort="name">
					                        번호
					                    </a>
					                </th>
					                <th>
					                    <a href="javascript: void(0);" class="text-muted list-sort" data-sort="email">
					                        제목
					                    </a>
					                </th>
					                <th>
					                    <a href="javascript: void(0);" class="text-muted list-sort" data-sort="id">
					                        작성자
					                    </a>
					                </th>
					                <th>
					                    <a href="javascript: void(0);" class="text-muted list-sort" data-sort="date">
					                        작성일
					                    </a>
					                </th>
					                <th class="w-150px min-w-150px">
					                    <a href="javascript: void(0);" class="text-muted list-sort" data-sort="status">
					                        조회수
					                    </a>
					                </th>
					                <th class="w-150px min-w-150px">
					                    <a href="javascript: void(0);" class="text-muted list-sort" data-sort="status">
					                        좋아요
					                    </a>
					                </th>
					            </tr>
					        </thead>
					
					        <tbody class="list">
					        	<c:if test="${empty boardList}">
						        	<tr>
						        		<td>
						        			<strong>게시글이 없습니다.</strong>	
						        		</td>
						        	</tr>
					        	</c:if>
						        	
						        <c:forEach items="${boardList }" var="boardList">
						        	<tr>
						                <td>
						                    <div class="form-check mb-0"><input class="form-check-input" type="checkbox" value=""></div>
						                </td>
						                <td>${boardList.board_no}</td>
						                <td>
						                	<a href="<%=request.getContextPath()%>/board/${boardList.board_no}">
						                		${boardList.title }
						                	</a>
						                </td>
						                <td>${boardList.writer }</td>
						                <td>${boardList.regdate }</td>
						                <td>${boardList.view_count }</td>
						                <td>${boardList.like_count }</td>
						            </tr>
								</c:forEach>
					    </table>
					</div> <!-- / .table-responsive -->
					
					<div class="card-footer">
					    <div class="d-flex justify-content-between align-items-center">
					        <div class="me-5 text-secondary small">
					            Showing: <span class="list-pagination-page-first">1</span> - <span class="list-pagination-page-last">8</span> of <span class="list-pagination-pages">20</span>
					        </div>
					
					        <!-- Pagination -->
							<ul class="pagination list-pagination mb-0" style="display: flex;">
						        <li class="paginate_item page-item disabled"><a class="paginate_button previous page-link" aria-controls="datatable" data-dt-idx="0" tabindex="0" id="datatable_previous"><span aria-hidden="true">Prev</span></a></li>
						        <li class="page-item active"><a class="page page-link" href="javascript: void(0);" data-i="1" data-page="8">1</a></li><li class="page-item"><a class="page page-link" href="javascript: void(0);" data-i="2" data-page="8">2</a></li><li class="page-item"><a class="page page-link" href="javascript: void(0);" data-i="3" data-page="8">3</a></li>
						   		<li class="paginate_item page-item"><a class="paginate_button next page-link" aria-controls="datatable" data-dt-idx="4" tabindex="0" id="datatable_next"><span aria-hidden="true">Next</span></a></li>
					    	</ul>
					    </div>
					</div>
                            
				</div>
			</div>
		
		</section>
	</main>
	<!-- Main End -->

<%@ include file="../include/footer.jsp" %>

<script>

	$(document).ready(function() {
		
		// 게시글 등록 페이지 이동 버튼 클릭
		$('#registFormBtn').on('click', function () {
			location.href = "<%=request.getContextPath()%>/board/registForm"
		});
		
	});
	
</script>