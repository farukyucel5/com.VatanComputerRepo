# com.VatanComputerRepo
Bu proje windows 11 pro işletim sisteminde Selenium test aracı ve java programlama dili kullanılarak TestNG framework'unda yazılmıştır.
Senaryo adımları aşağıdaki gibidir:

1. <https://www.vatanbilgisayar.com/> sitesini açılacak ve anasayfanın açıldığını onaylayacak

2. Login ekranını açıp, bir kullanıcı ile login olacak ( daha önce siteye üyeliğin varsa o olabilir )

3. Ekranın üstündeki Search alanına 'samsung' yazip 'Ara' butonuna tıklayacak

4. Sol menüden 'Cep Telefonu' tıklayacak

5. Gelen sayfada samsung için sonuç bulunduğunu onaylayacak

6. Arama sonuçlarından 2. sayfaya tıklayacak ve açılan sayfada 2. sayfanın şu an gösterimde olduğunu onaylayacak  (bu adım site otomasyon sürecinde tüm ürünleri tek
sayfa gösterdiği için yapılamadı ve atlandı)

7. Üstten 5. ürünü tıklayacak(Ürünlerin tek sayfada listelendiği sayfada)

8. Ürün detayında 'Beğen' butonuna tıklayacak

9. 'Ürün listenize eklendi.' popup kontrolü yapacak

10. Ekranın en üstündeki hesabım alanında 'Beğendiklerim' tıklayacak

11. Açılan sayfada bir önceki sayfada beğendiklerime alınmış ürünün bulunduğunu onaylayacak

12. Beğendiklerime alınmış ürün bulunup seçilecek ve sepete eklenecek

13. 'Ürün sepete eklendi' popup kontrolü yapacak

14. Sepetim sayfasına gidecek

15. Sepete eklenen bu ürünün içine girilip 'Kaldır' butonuna basılacak, sepetimden çıkarılacak

16. Bu ürünün artik sepette olmadığını onaylayacak

Log4j ve Allure report entegre edildi ve test verileri excel dosyasından çekildi ve kullanıldı.
Testin başarılı olup olmama durumu excel dosyasına kaydedildi.

ReusableMethods sınıfında kullanılan Excel dosyası yolu olan:
String excelFilePath=currentDir+"\\src\\test\\java\\DataPackage\\VatanComputer.xlsx";
bu yol windowns kullanıcıları için geçerlidir MAC kullanıcıları "\\" çift ters slash işaretini tek slash "/" olarak değiştirmeli aksi takdirde hata almaları muhtemel.

Test xml dosyasından çalıştırılmalı 
Test çalışıp bitince allure-results adında bir directory oluşacak ve burada allure report'un  json formatında dosyaları bulunur , bu dosyaları açıp raporu oluşturmak için,
terminale 
allure serve allure-results
komutu yazılıp enter'a basılmalı, bu işlemden sonra
rapor default browser'da açılacak.

