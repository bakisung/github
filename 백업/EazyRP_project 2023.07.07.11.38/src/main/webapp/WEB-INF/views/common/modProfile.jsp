<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
  <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="C:\Users\note_ma01\Desktop\bootstrap-datepicker-master\dist\css\bootstrap-datepicker.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

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

     <!-- 11111 -->
     <div class="h-60 col-lg-8" style="align-items: center; display: flex; justify-content: center;">
      <!-- .card -->
      <div class="card card-fluid" >
        
        
        <div class="card-body">
          <!-- form -->
          <!-- form -->
          <div class="d-flex align-items-center pb-3 mb-3 text-center link-dark text-decoration-none border-bottom">
            <span class="fs-5 fw-semibold "> 개인정보 수정 </span>
          </div>
          <form method="post">
            <!-- .form-group -->
          
            <div class="form-group">
              <label for="email">Email</label> 
              <div class="input-group">
                <input type="email" class="form-control" id="email" required="">
                <button type="submit" class="btn btn-primary" disabled>인증번호 전송</button>
              </div>
            </div>
            <div class="form-group">
              <label for="emailchk">인증번호</label> 
              <div class="input-group">
                <input type="email" class="form-control" id="emailchk">
                <button type="submit" class="btn btn-primary" disabled>인증번호 확인</button>
              </div>
            </div>
            <div class="form-group">
              <label for="input02">비밀번호 변경</label> 
              <input type="password" class="form-control" id="input02" required="">
            </div>
              <div class="form-group">  
              <label for="input02">비밀번호 확인</label> 
              <input type="password" class="form-control" id="input02" required="">
            </div><!-- /.form-group -->
              <button type="submit" class="btn btn-primary" disabled>비밀번호 변경</button>
              <button type="submit" class="btn btn-primary" disabled>취 소</button>
          </form><!-- /form -->
        </div><!-- /.card-body -->
      </div><!-- /.card -->
    </div>
  </div>
 
    
  </body>
  
  </html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

