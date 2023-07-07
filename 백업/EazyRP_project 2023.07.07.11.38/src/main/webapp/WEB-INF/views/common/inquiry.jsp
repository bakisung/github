<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
  $('#summernote').summernote({
    placeholder: 'Hello stand alone ui',
    tabsize: 2,
    height: 500,
    toolbar: [
      ['style', ['style']],
      ['font', ['bold', 'underline', 'clear']],
      ['color', ['color']],
      ['para', ['ul', 'ol', 'paragraph']],
      ['table', ['table']],
      ['insert', ['link', 'picture', 'video']],
      ['view', ['fullscreen', 'codeview', 'help']]
    ]
  });
</script>

<head>
  <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>문의사항</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/css/adminlte.min.css" rel="stylesheet">
<!-- summernote -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>


  <style>
    html, body{
      width: 100%;
      height: 100%;
    }
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }

    .b-example-divider {
      height: 3rem;
      background-color: rgba(0, 0, 0, .1);
      border: solid rgba(0, 0, 0, .15);
      border-width: 1px 0;
      box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .05);
    }

    .b-example-vr {
      flex-shrink: 0;
      width: 1.5rem;
      height: 100vh;
    }

    .bi {
      vertical-align: -.125em;
      fill: currentColor;
    }

    .p-2 {
      color: whitesmoke;
    }

    .nav d-flex {
      justify-content: space-evenly;
    }

  </style>
  <!-- Custom styles for this template -->
</head>

<body class="bg-light">

  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">로고</a>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        </ul>
        <div>
        </div>
      </div>

    </div>
  </nav>

  <div class="nav-scroller py-1 mb-2">
    <nav class="nav d-flex" style="background-color: #4685e4; justify-content:space-evenly;">
      <a class="p-2" style="color: white; text-decoration-line: none;" href="#">개인정보/문의</a>
      <a class="p-2" style="color: white; text-decoration-line: none;" href="#">나만의 메뉴</a>
      <a class="p-2" style="color: white; text-decoration-line: none;" href="#">재고 1</a>
      <a class="p-2" style="color: white; text-decoration-line: none;" href="#">재고 2</a>
      <a class="p-2" style="color: white; text-decoration-line: none;" href="#">관리</a>
    </nav>
  </div>
  
  <!-- main -->
  <div class="main" style="height: 80%; display: flex;">

    <!-- sidebar -->   
    <nav class="d-flex flex-column flex-shrink-0 p-3 bg-white " style=" float:left ; width: 20%; height: 100%; display: inline">
      <div class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
        <span class="fs-5 fw-semibold"> 개인정보 </span>
      </div>
      <ul class="list-unstyled ps-0">
        <li class="mb-1">
          <a class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
            개인정보 조회 및 수정
          </a>
        </li>
        <li class="mb-1">
          <a class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
            회원탈퇴
          </a>
        </li>
      </ul>
        <div class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
           <span class="fs-5 fw-semibold"> 관리자 문의 </span>
        </div>
        <ul class="list-unstyledv ps-0">
          <li class="mb-1" style="list-style: none;">
            <a class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
              관리자 문의하기
            </a>
          </li>
          <li class="mb-1" style="list-style: none;">
            <a class="btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
              문의 답변 확인
            </a>
          </li>
        </ul>     
        </nav>

  <!--1234512512124-->
  <div class="h-60 col-lg-8 container text-center;">

    <!-- .card -->
    <div class="card card-fluid" style="width: 80%;">
      <div class="card-body" style="text-align: center;">
        <!-- form -->
        <div class="d-flex align-items-center pb-3 mb-3 text-center link-dark text-decoration-none border-bottom">
          <span class="fs-5 fw-semibold "> 문의사항 </span>
        </div>  

        

        <!-- 제목 -->
        <div class="p-4 code-to-copy">
          <label class="form-label" for="exampleFormControlInput"></label>
          <input class="form-control" id="exampleFormControlInput" type="email" placeholder="제 목">
        </div>
        <!-- summernote적용-->
       <div class="p-4 code-to-copy">
      <div class="mb-3">
        <div id="summernote"></div>

      </div>
    </div>
    <button type="submit" class="btn btn-primary " disabled>등 록</button>
    <button type="submit" class="btn btn-primary " disabled>취 소</button>
  </div>
</div>
</div>
</div>

  <!-- footer -->
  


</body>
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/admin-lte@3.2/dist/js/adminlte.min.js"></script>
