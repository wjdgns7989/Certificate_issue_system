<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<html>

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
   integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
   crossorigin="anonymous">
</head>

<body>
   <!-- nav -->
   <nav class="nav bg-dark">
      <a class="nav-link active" href="#">세종대 로고</a>
   </nav>

   <!-- body -->
<body>
   <div class="container">
      <br> <br>
      <h2>증명발급 시스템 &nbsp;</h2>
      <hr>
      <ul class="nav nav-tabs" id="myTab" role="tablist">
         <li class="nav-item"><a class="nav-link active" id="home-tab"
            data-toggle="tab" href="#home" role="tab" aria-controls="home"
            aria-selected="true">재학</a></li>
         <li class="nav-item"><a class="nav-link" id="profile-tab"
            data-toggle="tab" href="#profile" role="tab" aria-controls="profile"
            aria-selected="false">졸업</a></li>
      </ul>
      <div class="tab-content" id="myTabContent">
         <div class="tab-pane fade show active" id="home" role="tabpanel"
            aria-labelledby="home-tab">
            <br>
            <table class="table table-bordered">
               <thead class="thead-dark">
                  <tr>
                     <th scope="col">구분</th>
                     <th scope="col">학교</th>
                     <th scope="col">학번</th>
                     <th scope="col">이름</th>
                  </tr>
               </thead>
               <tbody>
                  <tr>
                     <td>4학년2학기</td>
                     <td>세종대학교</td>
                     <td>11111111</td>
                     <td>홍길동</td>
                  </tr>
                  <tr>
                     <td colspan="4" class="center text-center"><span
                        class="d-inline-block text-center "> 2000.00.00 위 사람은
                           세종대학교에 재학 중임이 증명되었습니다. <img src="#none" alt="세종대로고">
                     </span></td>
                  </tr>
               </tbody>
            </table>
         </div>
         <div class="tab-pane fade" id="profile" role="tabpanel"
            aria-labelledby="profile-tab">
            <div class="tab-pane fade show active" id="home" role="tabpanel"
               aria-labelledby="home-tab">
               <br>
               <table class="table table-bordered">
                  <thead class="thead-dark">
                     <tr>
                        <th scope="col">구분</th>
                        <th scope="col">학교</th>
                        <th scope="col">학번</th>
                        <th scope="col">이름</th>
                     </tr>
                  </thead>
                  <tbody>
                     <tr>
                        <td>졸업</td>
                        <td>세종대학교</td>
                        <td>11111111</td>
                        <td>홍길동</td>
                     </tr>
                     <tr>
                        <td colspan="4" class="center text-center"><span
                           class="d-inline-block text-center "> 2000.00.00 위 사람은
                              세종대학교에서 졸업했음이 증명되었습니다. <img src="#none" alt="세종대로고">
                        </span></td>
                     </tr>
                  </tbody>
               </table>
            </div>
         </div>
      </div>
   </div>
   <div class="container">
      <hr>
      <form method="post" action="emailSender">
         <div class="form-group">
            <label for="blockchain">블록체인 값</label> <input class="form-control"
               id="blockchain" type="text" placeholder="124bds943kogdjisdim3"
               readonly> <small id="emailHelp"
               class="form-text text-muted">블록체인 주소를 요청해주세요</small>
         </div>
         <div class="form-group">
            <label for="email">이메일</label> <input class="form-control"
               id="email" type="email" placeholder="이메일" name="sender" >
         </div>
         <div class="row">
            <div class="col-3">

               <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox"
                     id="inlineCheckbox1" value="option1"> <label
                     class="form-check-label" for="inlineCheckbox1">재학</label>
               </div>
               <div class="form-check form-check-inline">
                  <input class="form-check-input" type="checkbox"
                     id="inlineCheckbox2" value="option2"> <label
                     class="form-check-label" for="inlineCheckbox2">졸업</label>
               </div>
            </div>
            <div class="col-7"></div>
            <div class="col-2">
               <input class="btn" type="submit" value="submit"> 
               <script type="text/javascript">
                  function result() {
                     alert("발급이 완료되었습니다.");
                  }
               </script>
            </div>
         </div>
   </div>
   </form>
   </div>

</body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
   integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
   crossorigin="anonymous"></script>
<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
   integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
   crossorigin="anonymous"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
   integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
   crossorigin="anonymous"></script>
</body>

</html>