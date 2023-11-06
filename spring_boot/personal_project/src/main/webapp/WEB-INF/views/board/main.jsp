<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
                    <!-- End Col -->

                    <div class="col-auto">
                      <!-- Select -->
                      <div class="tom-select-custom tom-select-custom-end">
                    
                    
                     <select class="form-control col-md-2 custom-select" name="searchType" id="searchType" style="font-size: 0.8em;">
								<option value="ne" ${cri.searchType eq 'ne' ? 'selected' : '' }>코드번호 + 담당자</option>
								<option value="n" ${cri.searchType eq 'n' ? 'selected' : '' }>코드번호</option>
								<option value="e" ${cri.searchType eq 'e' ? 'selected' : '' }>담당자</option>
							</select>
							
							
                      </div>
                      <!-- End Select -->
                    </div>
                    <!-- End Col -->
                    
                    
                    
                    
                    
                  </div>
                  <!-- End Row -->
                </div>
                <!-- End Col -->


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
	                <button class="btn btn-success" id="registBtn">등록</button>
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
                                                    Full name
                                                </a>
                                            </th>
                                            <th>
                                                <a href="javascript: void(0);" class="text-muted list-sort" data-sort="email">
                                                    Email
                                                </a>
                                            </th>
                                            <th>
                                                <a href="javascript: void(0);" class="text-muted list-sort" data-sort="id">
                                                    User ID
                                                </a>
                                            </th>
                                            <th>
                                                <a href="javascript: void(0);" class="text-muted list-sort" data-sort="date">
                                                    Signed up
                                                </a>
                                            </th>
                                            <th class="w-150px min-w-150px">
                                                <a href="javascript: void(0);" class="text-muted list-sort" data-sort="status">
                                                    Status
                                                </a>
                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody class="list"><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Hakeem Chan</span>
                                            </td>
                                            <td class="email">lobortis.augue@natoquepenatibuset.ca</td>
                                            <td class="id">#9265</td>
                                            <td class="date" data-signed="1648252800">03.26.2022</td>
                                            <td class="status"><span class="legend-circle bg-success"></span>Successful</td>
                                        </tr><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Orli J. Goodman</span>
                                            </td>
                                            <td class="email">pede@at.com</td>
                                            <td class="id">#8545</td>
                                            <td class="date" data-signed="1627858800">08.02.2021</td>
                                            <td class="status"><span class="legend-circle bg-success"></span>Successful</td>
                                        </tr><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Halee P. Lane</span>
                                            </td>
                                            <td class="email">diam@nislNullaeu.net</td>
                                            <td class="id">#4445</td>
                                            <td class="date" data-signed="1615680000">03.14.2021</td>
                                            <td class="status"><span class="legend-circle bg-warning"></span>Pending</td>
                                        </tr><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Kimberly Salinas</span>
                                            </td>
                                            <td class="email">in.lobortis.tellus@faucibusorci.co.uk</td>
                                            <td class="id">#2391</td>
                                            <td class="date" data-signed="1615939200">03.17.2021</td>
                                            <td class="status"><span class="legend-circle bg-success"></span>Successful</td>
                                        </tr><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Galena Oliver</span>
                                            </td>
                                            <td class="email">eleifend.nec@ligulaconsectetuerrhoncus.ca</td>
                                            <td class="id">#8987</td>
                                            <td class="date" data-signed="1607990400">12.15.2021</td>
                                            <td class="status"><span class="legend-circle bg-warning"></span>Pending</td>
                                        </tr><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Kelly Doyle</span>
                                            </td>
                                            <td class="email">urna.et@volutpatNulladignissim.org</td>
                                            <td class="id">#5898</td>
                                            <td class="date" data-signed="1650495600">04.21.2022</td>
                                            <td class="status"><span class="legend-circle bg-danger"></span>Overdue</td>
                                        </tr><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Keane Wyatt</span>
                                            </td>
                                            <td class="email">quam@Ut.org</td>
                                            <td class="id">#3431</td>
                                            <td class="date" data-signed="1655506800">06.18.2022</td>
                                            <td class="status"><span class="legend-circle bg-success"></span>Successful</td>
                                        </tr><tr>
                                            <td>
                                                <div class="form-check mb-0">
                                                    <input class="form-check-input" type="checkbox" value="">
                                                </div>
                                            </td>
                                            <td>
                                                <span class="name fw-bold">Nasim Aguirre</span>
                                            </td>
                                            <td class="email">nisl@mollis.net</td>
                                            <td class="id">#6701</td>
                                            <td class="date" data-signed="1602975600">10.18.2021</td>
                                            <td class="status"><span class="legend-circle bg-danger"></span>Overdue</td>
                                        </tr></tbody>
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

	$(document).ready(function()){
		
		// 게시글 등록 버튼 클릭
		$('#registBtn').on('click', function () {
			location.href = "<%=request.getContextPath()%>/board/registForm"
		})	
	
	}
	
</script>