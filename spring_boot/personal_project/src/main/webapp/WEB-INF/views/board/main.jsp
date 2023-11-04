<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp" %>

	<!-- Main Start -->
	<main>
		<section class="py-5 text-center container">
		
			<div class="card border-0 flex-fill w-100" data-list="{&quot;valueNames&quot;: [&quot;name&quot;, &quot;email&quot;, &quot;id&quot;, {&quot;name&quot;: &quot;date&quot;, &quot;attr&quot;: &quot;data-signed&quot;}, &quot;status&quot;], &quot;page&quot;: 8}" id="users">
				<div class="card-header border-0 card-header-space-between">
				    <!-- Title -->
					<h2 class="card-header-title h4 text-uppercase">
					    Users
					</h2>
					<!-- Dropdown -->
					<div class="dropdown ms-4">
						<a href="javascript: void(0);" class="dropdown-toggle no-arrow text-secondary" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" height="14" width="14"><g><circle cx="12" cy="3.25" r="3.25" style="fill: currentColor"></circle><circle cx="12" cy="12" r="3.25" style="fill: currentColor"></circle><circle cx="12" cy="20.75" r="3.25" style="fill: currentColor"></circle></g></svg>
						</a>
						<div class="dropdown-menu">
						    <a href="javascript: void(0);" class="dropdown-item">
						        Export report
						    </a>
						    <a href="javascript: void(0);" class="dropdown-item">
						        Share
						    </a>
						    <a href="javascript: void(0);" class="dropdown-item">
						        Action
						    </a>
						</div>
					</div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <img src="https://d33wubrfki0l68.cloudfront.net/9e7ac59225f733be5944b3e91271b33adb30cae7/56230/assets/images/profiles/profile-14.jpeg" alt="..." class="avatar-img" width="30" height="30">
                                                </div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <img src="https://d33wubrfki0l68.cloudfront.net/44bfbd93721837b9534e9dc6fc058dbaef92d03a/f9236/assets/images/profiles/profile-23.jpeg" alt="..." class="avatar-img" width="30" height="30">
                                                </div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <img src="https://d33wubrfki0l68.cloudfront.net/236af360580cfc7622e3a7d309d709a5018937c5/e3ee4/assets/images/profiles/profile-16.jpeg" alt="..." class="avatar-img" width="30" height="30">
                                                </div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <span class="avatar-title text-bg-primary-soft">KS</span>
                                                </div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <img src="https://d33wubrfki0l68.cloudfront.net/963edcf9fc0c25098f00370b3b3d021e2ddac277/e69d6/assets/images/profiles/profile-17.jpeg" alt="..." class="avatar-img" width="30" height="30">
                                                </div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <img src="https://d33wubrfki0l68.cloudfront.net/768c1ecfdff6a59ab55d514b80bd59e8dfa28996/35a64/assets/images/profiles/profile-19.jpeg" alt="..." class="avatar-img" width="30" height="30">
                                                </div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <img src="https://d33wubrfki0l68.cloudfront.net/0b34af989cce5e54297f16547b3eff1ace44dad5/eb8ea/assets/images/profiles/profile-20.jpeg" alt="..." class="avatar-img" width="30" height="30">
                                                </div>
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
                                                <div class="avatar avatar-circle avatar-xs me-2">
                                                    <span class="avatar-title text-bg-success-soft">NA</span>
                                                </div>
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
                                    <ul class="pagination list-pagination mb-0" style="display: flex;"><li class="page-item active"><a class="page page-link" href="javascript: void(0);" data-i="1" data-page="8">1</a></li><li class="page-item"><a class="page page-link" href="javascript: void(0);" data-i="2" data-page="8">2</a></li><li class="page-item"><a class="page page-link" href="javascript: void(0);" data-i="3" data-page="8">3</a></li></ul>
                                </div>
                            </div>
                            
                        </div>
		
		</section>
	</main>
	<!-- Main End -->

<%@ include file="../include/footer.jsp" %>

<script>
	$(document).ready(function()){
		
	}
</script>






