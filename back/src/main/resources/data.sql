INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO klub(id, naziv, budzet) VALUE(1, 'FK Crvena zvezda', 20000);
INSERT INTO klub(id, naziv, budzet) VALUE(2, 'FK Partizan', 15000);
INSERT INTO klub(id, naziv, budzet) VALUE(3, 'FK Barcelona', 35000);
INSERT INTO klub(id, naziv, budzet) VALUE(4, 'FK Liverpool', 37000);

INSERT INTO igrac(id, imeiprezime, pozicija, broj_dresa, datum_rodjenja, na_prodaju, klub_id) VALUE(1, 'Cristiano Ronaldo', 'Napadac', 7, '1986-05-15', true, 4);
INSERT INTO igrac(id, imeiprezime, pozicija, broj_dresa, datum_rodjenja, na_prodaju, klub_id) VALUE(2, 'Nemanja Matic', 'Defanzivac', 10, '1989-08-15', false, 1);
INSERT INTO igrac(id, imeiprezime, pozicija, broj_dresa, datum_rodjenja, na_prodaju, klub_id) VALUE(3, 'Luis Figo', 'Napadac', 8, '1995-07-15', true, 2);
INSERT INTO igrac(id, imeiprezime, pozicija, broj_dresa, datum_rodjenja, na_prodaju, klub_id) VALUE(4, 'David Luiz', 'Golman', 1, '1994-05-15', false, 3);