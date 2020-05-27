<%@ page import="dto.StudentDTO" %>
<%@ page import="dto.RoleDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>OrientITM</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/internal/logIn.css">
    <link rel="stylesheet" href="css/internal/style.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:700|Raleway:400,400i,600&display=swap&subset=cyrillic"
          rel="stylesheet">
    <link rel="stylesheet" href="css/external/jquery-ui.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script src="js/external/jquery-ui.js"></script>
    <script src="js/external/1e5161a27d.js" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="js/internal/load.js"></script>
    <script src="js/internal/action.js"></script>
</head>
<body>
<!--Header-->
<header id="header">
    <div class="container">
        <div class="inner__head">
            <div class="logo__head">
                <a id="logo" href="http://localhost:8087/orientitm/"> <img style="width: 70%"
                                                                           src="img/orientitm-logo.png"
                                                                           alt="logo"></a>
            </div>
            <div class="mynav">
                <a href="#" class="my__link">Haqqımızda</a>
                <a href="#" class="my__link">Təlimçilər</a>
                <a href="#" class="my__link">Kurslar</a>
                <a href="#" class="my__link">İT xəbərlər</a>
                <a href="#" class="my__link">Əlaqə</a>
            </div>
        </div>
        <%------------------log in---------------%>
        <%
            StudentDTO student = (StudentDTO) session.getAttribute("student");
            List<String> rolesName = new ArrayList<>();
            if (student == null) {
        %>
        <div id="logIn" style="width: 100%;display: flex;justify-content: flex-end;margin-top: 25px">
            <form action="cnt?action=logInUser" method="post">
                <div style="display: flex;flex-direction: row" class="input-group form-group">
                    <div style="display: flex;justify-content: center;margin-right: 10px" class="input-group-prepend">
                        <span style="background-color: #175F82;border-bottom-left-radius: 5px;border-top-left-radius:5px;display: flex;align-items: center;justify-content: center "
                              class="input-group-text"><i style="color: white" class="fas fa-user"></i></span>
                        <input name="email" style="background-color: #6069a2;border: none;color: white" type="text"
                               class="form-control" placeholder="email">
                    </div>
                    <div style="display: flex;justify-content: center;margin-right:10px;" class="input-group-prepend">
                        <span style="background-color: #175F82;border-bottom-left-radius: 5px;border-top-left-radius:5px;display: flex;align-items: center;justify-content: center "
                              class="input-group-text"><i style="color: white" class="fas fa-key"></i></span>
                        <input name="password" style="background-color: #6069a2;border: none;color: white"
                               type="password" class="form-control" placeholder="şifrə">
                    </div>
                    <input type="submit" value="Daxil ol" id="logInBtn">
                </div>
                <% String errorMesage = (String) session.getAttribute("errorMessage");
                    if (errorMesage != null) {%>
                <p id="errorMessage"
                   style="font-weight: 500;color: red;display: flex;justify-content: center"><%=errorMesage%>
                </p>
                <script>
                    setTimeout(function () {
                        $('#errorMessage').hide();
                    }, 4000);
                </script>
                <%}%>
            </form>
        </div>
        <%} else {%>
        <div id="logIn" style="width: 100%;display: flex;justify-content: flex-end;margin-top: 25px">
            <p style="color: white;font-weight: 300;font-size: 15px;background-color: #175F82;padding: 8px 20px;border-radius: 25px;text-transform: uppercase"><%=student.getName()%>
                <%=student.getSurname()%>
                <span><a href="cnt?action=logOut"><i id="logOutBtn" class="fas fa-sign-out-alt"></i></a></span>
            </p>
        </div>
        <%
            List<RoleDTO> roles = student.getRoles();
            for (RoleDTO role : roles) {
                rolesName.add(role.getName());
            }
        %>
        <%}%>
    </div>
</header>
<!--Intro-->
<div class="intro" id="intro">
    <div class="container">
        <div id="introSentences">
            <h2 class="inner__intro">Life begins at the end of your comfort zone</h2>
            <h2 class="sub__intro">Code your ideas with us</h2>
        </div>
        <button class="studentReqBtn myBtn red--btn">Müraciət et</button>
        <div id="completeMessage" style="margin-top: 35px;font-size: 18px;color: #ffffff">

        </div>
        <%--Telebenin tesdiq mesaji--%>
        <div>
            <%
                StudentDTO a = (StudentDTO) request.getAttribute("studentName");
                if (a != null) {
            %>
            <div id="testDiv" style="margin-top: 35px;font-size: 18px;color: #ffffff">
                <i class="fas fa-check"></i> Hörmətli <%=a.getName()%>
                <% if ("male".equalsIgnoreCase(a.getGender())) {
                %> bəy<%} else {%>xanım<%}%>, sizin müraciətiniz uğurla nəticələndi,zəngimizi gözləyin ☺
            </div>
            <script>
                setTimeout(function () {
                    $('#testDiv').hide();
                }, 9000);
            </script>
            <%}%>
        </div>
    </div>
</div>
<div id="dialog-form" title="Qeyydiyyat forması"></div>
<div id="edit-form" title="Redaktə forması"></div>
<!--Feature-->
<div class="container">
    <div class="features">
        <div class="features__items">
            <img class="feature__img" src="img/feature-1.png">
            <h3 class="feature__title">Java</h3>
            <div class="feature__text">
                <ul class="list">
                    <li>Müddəti: 6 ay</li>
                    <li> Ödəniş: 140AZN/ay</li>
                    <li>Təlimçi: <span style="color:#003eff;font-weight: 700">Taleh Alqayev</span></li>
                    <li> 4 saat/həftə</li>
                </ul>
            </div>
        </div>
        <div class="features__items">
            <img class="feature__img" src="img/feature-2.png">
            <h3 class="feature__title">C#</h3>
            <div class="feature__text">
                <ul class="list">
                    <li>Müddəti: 6 ay</li>
                    <li> Ödəniş: 140AZN/ay</li>
                    <li>Təlimçi: <span style="color:#003eff;font-weight: 700">Ehtiram Hacıxanov</span></li>
                    <li> 4 saat/həftə</li>
                </ul>
            </div>
        </div>
        <div class="features__items">
            <img class="feature__img" src="img/feature-3.png">
            <h3 class="feature__title">Android</h3>
            <div class="feature__text">
                <ul class="list">
                    <li>Müddəti: 2 ay</li>
                    <li> Ödəniş: 160AZN/ay</li>
                    <li>Təlimçi: <span style="color:#003eff;font-weight: 700">Ehtiram Hacıxanov</span></li>
                    <li> 4 saat/həftə</li>
                </ul>
            </div>
        </div>
        <div class="features__items">
            <img class="feature__img" src="img/feature-4.png">
            <h3 class="feature__title">C++</h3>
            <div class="feature__text">
                <ul class="list">
                    <li>Müddəti: 4 ay</li>
                    <li> Ödəniş: 120AZN/ay</li>
                    <li>Təlimçi: <span style="color:#003eff;font-weight: 700">Fuad Paşabəyli</span></li>
                    <li> 4 saat/həftə</li>
                </ul>
            </div>
        </div>
        <div class="features__items">
            <img class="feature__img" src="img/feature-5.png">
            <h3 class="feature__title">PostgreSQL</h3>
            <div class="feature__text">
                <ul class="list">
                    <li>Müddəti: 4 ay</li>
                    <li> Ödəniş: 160AZN/ay</li>
                    <li>Təlimçi: <span style="color:#003eff;font-weight: 700">Şahin Kərimov</span></li>
                    <li> 4 saat/həftə</li>
                </ul>
            </div>
        </div>
        <div class="features__items">
            <img class="feature__img" src="img/feature-6.png">
            <h3 class="feature__title">Photoshop</h3>
            <div class="feature__text">
                <ul class="list">
                    <li>Müddəti: 2 ay</li>
                    <li> Ödəniş: 90AZN/ay</li>
                    <li>Təlimçi: <span style="color:#003eff;font-weight: 700">Təhminə Ələkbərova</span></li>
                    <li> 4 saat/həftə</li>
                </ul>
            </div>
        </div>
    </div><!--/features-->
</div><!--/container-->

<!--Teachers-->
<div class="teachers">
    <div class="teachers__item">
        <img class="teachers__photo" src="img/Taleh.jpg" alt="Taleh">
        <div class="teachers__content">
            <div class="teachers__title">Taleh Alqayev</div>
            <div class="teachers__text">Hal-hazırda Elektron Hökümət Portalında baş proqramçı olaraq çalışır</div>
        </div>
    </div>
    <div class="teachers__item">
        <img class="teachers__photo" src="img/Ehtiram.jpg" alt="Ehtiram">
        <div class="teachers__content">
            <div class="teachers__title">Ehtiram Hacıxanov</div>
            <div class="teachers__text">Hal-hazırda Kapital bankda baş proqramçı olaraq çalışır</div>
        </div>
    </div>
    <div class="teachers__item">
        <img class="teachers__photo" src="img/Shahin.jpg" alt="Shahin">
        <div class="teachers__content">
            <div class="teachers__title">Şahin Kərimov</div>
            <div class="teachers__text">Hal-hazırda Respublika bankda departament direktoru olaraq çalışır</div>
        </div>
    </div>
    <div class="teachers__item">
        <img class="teachers__photo" src="img/Fuad.jpg" alt="Fuad">
        <div class="teachers__content">
            <div class="teachers__title">Fuad Paşabəyli</div>
            <div class="teachers__text">Hal-hazırda Turan bankda departament direktoru olaraq çalışır</div>
        </div>
    </div>
</div>
<div class="korporativ">
    <h3>Korporativ müştərilərimiz:</h3>
</div>

<!--clients-->
<div class="clients">
    <div class="container">
        <div class="inner__clients">
            <div class="clients__item">
                <img class="clients__photo" src="img/expressbank.png" alt="expressbank">
                <div class="client__content">
                    <div class="client__title">Expresbank ASC</div>
                    <div class="client__slogan">İşiniz rahat getsin</div>
                    <div class="client__text">Expressbank-ın əsas məqsədi müasir bank texnologiyalarından istifadə
                        etməklə, fərqli xidmət təqdim etmək və müştərilərdə məmnunluq yaratmaqdır. Bunun üçün Bankda
                        peşəkar və motivasiyalı komanda fəaliyyət göstərir. Strateji hədəfləri rəhbər tutaraq
                        fəaliyyətini davam etdirən Expressbank ölkənin stabil inkişaf edən və güclü maliyyə
                        göstəricilərinə malik olan banklar sırasındadır.
                    </div>
                </div>
            </div>
            <div class="clients__item">
                <img class="clients__photo" src="img/kapitalbank.png " alt="kapitalbank">
                <div class="client__content">
                    <div class="client__title">Kapitalbank ASC</div>
                    <div class="client__slogan">Birinci bank</div>
                    <div class="client__text">Həyatınızın hər bir dönəmində şəffaf maliyyə tərəfdaşlığımızla
                        ölkəmizin
                        sosial-iqtisadi rifah
                        halını birlikdə yüksəltməkdir.
                    </div>
                </div>
            </div>
            <div class="clients__item">
                <div><img class="clients__photo" src="img/turanbank.png" alt="expressbank"></div>
                <div class="client__content">
                    <div class="client__title">Turanbank ASC</div>
                    <div class="client__slogan">Bizimlə etibarlıdır</div>
                    <div class="client__text">TuranBankı respublikanın bütün regional mərkəzlərində satış şəbəkəsi
                        vasitəsi ilə bütün respublika üzrə əhali, mikro, kiçik və orta sahibkarlığa xidmət göstərən,
                        xarici investisiyalı pərakəndəyönümlü universal bank etmək.
                    </div>
                </div>
            </div>
            <div class="clients__item">
                <div><img class="clients__photo" src="img/azercell.png" alt="expressbank"></div>
                <div class="client__content">
                    <div class="client__title">Azercell Telekom MMC</div>
                    <div class="client__slogan">Rəqəmsal dünyadı dəyiş</div>
                    <div class="client__text">Məqsədimiz Yeni Nəsil Telekommunikasiya şirkətinə çevrilmək üçün
                        şirkəti
                        növbəti səviyyəyə çatdırmaqdır. İşgüzar fəaliyyətimizi genişləndirmək və gündəlik işimizdə
                        həvəslə çalışmaq üçün həqiqətən müştərilərimizin marağına uyğun xidmət göstərməliyik.

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--student-->
<div class="student">
    <div class="items">
        <h1 style="color: red;margin-bottom: 50px;font-size:27px;font-weight: 700;text-transform: uppercase">
            Sualınız
            var? <span
                style="color: white">Gəlin, görüşək</span>
        </h1>
        <img style="position: absolute ; z-index: -1; width: 100%; max-width: 1287px" src="img/student.jpg"
             alt="student">
        <%--------------map------------------%>
        <div class="mapouter">
            <div class="gmap_canvas">
                <iframe width="584" height="277" id="gmap_canvas"
                        src="https://maps.google.com/maps?q=af%20business&t=&z=15&ie=UTF8&iwloc=&output=embed"
                        frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
            </div>
            <style>.mapouter {
                position: relative;
                border-radius: 10px;
                text-align: right;
                height: 300px;
                width: 584px;
            }

            .gmap_canvas {
                overflow: hidden;
                border-radius: 10px;
                background: none !important;
                height: 300px;
                width: 584px;
            }</style>
        </div>
    </div>
</div>
<!--bottom-->
<div class="bottom">
    <div class="container">
        <div class="bottom__title">Seçim etməkdə çətinlik çəkməyin</div>
        <div class="bottom__text">biz kömək edərik</div>
        <div style="display: flex;flex-direction: column;justify-content: center;align-items: center">
            <button class="studentReqBtn myBtn red--btn long--btn">Müraciət et</button>
            <%if (rolesName != null && rolesName.contains("moderator") || rolesName.contains("admin")) {%>
            <button id="tableButton" class="myBtn orange--btn long--btn">Tələbələrin siyahısı</button>
            <table id="myTable" class="table table-bordered" style="width:100%;margin:15px auto">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Ad</th>
                    <th>Soyad</th>
                    <th>E-mail</th>
                    <th>Əlaqə nömrəsi</th>
                    <th>Seçdiyi proqram</th>
                    <th style="display: flex; justify-content: flex-end">redaktə et/sil</th>
                </tr>
                </thead>
                <tbody id="tableBody">

                </tbody>
            </table>
            <%
                }
                if (rolesName != null && rolesName.contains("admin")) {
            %>
            <button id="moderatorsTableButton" class="myBtn orange--btn long--btn">Admin və Moderatorların siyahısı
            </button>
            <table id="moderatorsTable" class="table table-bordered" style="width:100%;margin:15px auto">
                <thead>
                <tr>
                    <th>№</th>
                    <th>Ad</th>
                    <th>Soyad</th>
                    <th>E-mail</th>
                    <th>Vəzifəsi</th>
                    <th style="display: flex; justify-content: flex-end">redaktə et/sil</th>
                </tr>
                </thead>
                <tbody id="moderatorsTableBody">

                </tbody>
            </table>

            <%}%>
        </div>
    </div>
</div>
<div id="modalDelete"></div>
<div id="modalModerators"></div>
<div id="modalEdit"></div>
<!--footer-->
<footer class="footer">
    <div class="container">
        <div class="footer__inner">
            <div class="footer__block">
                <h4 class="footer__title">Ünvan</h4>
                <div class="footer__text">
                    <p>Nizami küç. 203B, AF Business House , 4-cü mərtəbə</p>
                </div>
            </div>
            <div class="footer__block">
                <h4 class="footer__title">Sosial şəbəkə</h4>
                <div class="footer__text">
                    <div class="social">
                        <img src="img/facebook.png" alt="facebook" class="icons">
                        <img src="img/instagram.png" alt="instagram" class="icons">
                        <img src="img/linkedin.png" alt="linkedin" class="icons">
                        <img src="img/youtube.png" alt="youtube" class="icons">
                    </div>
                </div>
            </div>
            <div class="footer__block">
                <h4 class="footer__title">Bizimlə Əlaqə</h4>
                <div class="footer__text">
                    <p><img style="margin: 15px 5px 0 0" src="img/telephone.png">0514336451, 0125990420</p>
                    <p><img style="margin: 15px 5px 0 0" src="img/message.png"> info@orient-itm.com</p>
                </div>
            </div>
        </div>
    </div>
</footer>
<div class="footer__copyright">
    <div style="text-align: center;color: #fff;font-size: 10px" class="div">
        © Copyright Agaeff
    </div>
</div>
</body>
</html>