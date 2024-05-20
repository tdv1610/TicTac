CREATE TABLE AD (
    EMAILAD VARCHAR2(50),
	TENAD NVARCHAR2(50),
	MATKHAU VARCHAR2(50)
);

----------------------------------------------------------------
CREATE TABLE NGUOIDUNG (
    EMAILND VARCHAR2(50),
    TENND NVARCHAR2(50),
    MATKHAU VARCHAR2(30)
);

---------------------------------------------------------------
CREATE TABLE NGUOIDUNG_NHOM(
    EMAILND VARCHAR2(50),
    MANHOM VARCHAR2(30)
);

---------------------------------------------------------------
CREATE TABLE NHOM(
    MANHOM VARCHAR2(30),
    TENNHOM NVARCHAR2(50),
    EMAIL_TRUONGNHOM VARCHAR2(50)
    
);

---------------------------------------------------------------
CREATE TABLE CONGVIEC (
    MACV VARCHAR2(30),
    MANHOM VARCHAR2(30),
    TENCV NVARCHAR2(50),
    LINHVUC NVARCHAR2(60),
    MOTACV CLOB,
    MUC_UUTIEN INT,
    NGAYBD DATE,
    NGAYKT DATE
);

---------------------------------------------------------------
CREATE TABLE THUCHIEN (
    EMAIL_TV VARCHAR2(50),
    MACV_PC VARCHAR2(30),
    MANHOM VARCHAR2(30),
    TRANGTHAI VARCHAR2(30)
);


----------------------------------------------------------------
--TABLE LICH






----------------------------------------------------------------
grant unlimited tablespace to c##tictac;
REM INSERTING into AD
SET DEFINE OFF;
INSERT INTO AD VALUES ('22521438@gm.uit.edu.vn', 'Hu?nh Anh Th?', '1234athu');
INSERT INTO AD VALUES ('22521455@gm.uit.edu.vn', 'Ho�ng D??ng Ng?c Th?y', '2252thuy');
INSERT INTO AD VALUES ('khanhphuong06@gmail.com', 'Tr?n Kh�nh Ph??ng', '062004');
INSERT INTO AD VALUES ('quocanhle@gmail.com', 'L� Nguy?n Qu?cc Anh', 'anhle2222');
INSERT INTO AD VALUES ('ngocanhnguyen@gmail.com', 'Nguy?n L� Ng?c Anh', 'ahihihi');

REM INSERTING into NGUOIDUNG
SET DEFINE OFF;
INSERT INTO NGUOIDUNG VALUES ('22521366@gm.uit.edu.vn', 'Thanh Tr?n', '1366thanh');
INSERT INTO NGUOIDUNG VALUES ('phongle@gmail.com', 'L� Thanh Phong', '246810phong');
INSERT INTO NGUOIDUNG VALUES ('baonhanxyz@gmail.com', 'Nh�n L�', 'abcd1234');
INSERT INTO NGUOIDUNG VALUES ('thuytrang004@gmail.com', 'Trang', 'tttranggg');

REM INSERTING into NGUOIDUNG_NHOM
SET DEFINE OFF;
INSERT INTO NGUOIDUNG_NHOM VALUES ('22521366@gm.uit.edu.vn','1');
INSERT INTO NGUOIDUNG_NHOM VALUES ('phongle@gmail.com', '1');
INSERT INTO NGUOIDUNG_NHOM VALUES ('baonhanxyz@gmail.com', '2');
INSERT INTO NGUOIDUNG_NHOM VALUES ('thuytrang004@gmail.com','2');
INSERT INTO NGUOIDUNG_NHOM VALUES ('abcd1234@gmail.com.vn','2');
REM INSERTING into NHOM
SET DEFINE OFF;
INSERT INTO NHOM VALUES ('1', 'Ch?y ?? �n sml', '22521366@gm.uit.edu.vn');
INSERT INTO NHOM VALUES ('2', '�n thi sml', 'thuytrang004@gmail.com');

REM INSERTING into CONGVIEC
SET DEFINE OFF;
INSERT INTO CONGVIEC VALUES ('1', '1', 'T?o giao di?n ?? �n', 'CNTT', 'T?o b?ng Java Swing', 1, '01-MAY-24', '15-MAY-24');
INSERT INTO CONGVIEC VALUES ('2', '1', 'T?o database', 'CNTT', 'T?o trong Oracle', 1, '10-MAY-24', '15-MAY-24');
INSERT INTO CONGVIEC VALUES ('3', '1', 'H?c SD Github', 'CNTT', 'T? t�m ki?m ngu?n h?c', 3, '01-MAY-24', '16-MAY-24');
INSERT INTO CONGVIEC VALUES ('4', '2', '�n thi CK HDH', 'CNTT', 'T�m t�i li?u �n', 2, '15-MAY-24', '16-JUN-24');
INSERT INTO CONGVIEC VALUES ('5', '2', 'L?y g?c HQTCSDL', 'CSDL', 'T�m b�i gi?ng', 2, '10-MAY-24', '15-JUN-24');
INSERT INTO CONGVIEC VALUES ('6', '2', 'Hoc HQTCSDL', 'CSDL', 'Lam Bai Tap', 2, '22-MAY-24', '15-JUN-24');
REM INSERTING into THUCHIEN
SET DEFINE OFF;
INSERT INTO THUCHIEN VALUES ('22521366@gm.uit.edu.vn', '1','1', 'C?n l�m');
INSERT INTO THUCHIEN VALUES ('22521366@gm.uit.edu.vn', '3','1', 'C?n l�m');
INSERT INTO THUCHIEN VALUES ('phongle@gmail.com', '2','1' ,'C?n l�m');
INSERT INTO THUCHIEN VALUES ('baonhanxyz@gmail.com', '4','2', 'C?n l�m');
INSERT INTO THUCHIEN VALUES ('thuytrang004@gmail.com', '5','2', '?ang l�m');
INSERT INTO THUCHIEN VALUES ('abcd1234@gmail.com.vn', '6','2', 'C?n l�m');
--------------------------------------------------------------------------------
--  Constraints for Table AD 
--------------------------------------------------------

  ALTER TABLE "AD" ADD CONSTRAINT "PK_AD" PRIMARY KEY ("EMAILAD")
  USING INDEX  ENABLE;
  ALTER TABLE "AD" MODIFY ("EMAILAD" NOT NULL ENABLE);
  ALTER TABLE "AD" MODIFY ("TENAD" NOT NULL ENABLE);
  ALTER TABLE "AD" MODIFY ("MATKHAU" NOT NULL ENABLE);

select *from NGUOIdung;
--------------------------------------------------------------------------------
--  Constraints for Table NGUOIDUNG
--------------------------------------------------------

  ALTER TABLE "NGUOIDUNG" ADD CONSTRAINT "PK_NGUOIDUNG" PRIMARY KEY ("EMAILND")
  USING INDEX  ENABLE;
  ALTER TABLE "NGUOIDUNG" MODIFY ("EMAILND" NOT NULL ENABLE);
  ALTER TABLE "NGUOIDUNG" MODIFY ("TENND" NOT NULL ENABLE);
  ALTER TABLE "NGUOIDUNG" MODIFY ("MATKHAU" NOT NULL ENABLE);
  
----------------------------------------------------------
--  Constraints for Table NGUOIDUNG_NHOM
--------------------------------------------------------

  ALTER TABLE "NGUOIDUNG_NHOM" ADD CONSTRAINT "PK_NHOM" PRIMARY KEY ("EMAILND","MANHOM")
  USING INDEX  ENABLE;
    ALTER TABLE "NGUOIDUNG_NHOM" MODIFY ("EMAILND" NOT NULL ENABLE);
  ALTER TABLE "NGUOIDUNG_NHOM" MODIFY ("MANHOM" NOT NULL ENABLE);
  ALTER TABLE "NGUOIDUNG_NHOM" ADD CONSTRAINT "FK_NDTHUOCNHOM" FOREIGN KEY ("EMAILND")
	  REFERENCES "NGUOIDUNG" ("EMAILND") ENABLE;
  ALTER TABLE "NGUOIDUNG_NHOM" ADD CONSTRAINT "FK_THUOCNHOM" FOREIGN KEY ("MANHOM")
	  REFERENCES "NHOM" ("MANHOM") ENABLE;
--------------------------------------------------------
--  Constraints for Table NHOM
--------------------------------------------------------


  ALTER TABLE "NHOM" ADD CONSTRAINT "PK_NHOM" PRIMARY KEY ("MANHOM")
  USING INDEX  ENABLE;
  ALTER TABLE "NHOM" MODIFY ("MANHOM" NOT NULL ENABLE);
  ALTER TABLE "NHOM" MODIFY ("TENNHOM" NOT NULL ENABLE);
  ALTER TABLE "NHOM" MODIFY ("EMAIL_TRUONGNHOM" NOT NULL ENABLE);
  ALTER TABLE "NHOM" ADD CONSTRAINT "FK_TRUONGNHOM" FOREIGN KEY ("EMAIL_TRUONGNHOM")
	  REFERENCES "NGUOIDUNG" ("EMAILND") ENABLE;
  
--------------------------------------------------------
--  Constraints for Table CONGVIEC
--------------------------------------------------------
  ALTER TABLE "CONGVIEC" ADD CONSTRAINT "PK_CONGVIEC" PRIMARY KEY ("MACV")
  USING INDEX  ENABLE;
  ALTER TABLE "CONGVIEC" MODIFY ("MACV" NOT NULL ENABLE);
  ALTER TABLE "CONGVIEC" MODIFY ("MANHOM" NOT NULL ENABLE);
  ALTER TABLE "CONGVIEC" MODIFY ("TENCV" NOT NULL ENABLE);
   ALTER TABLE "CONGVIEC" ADD CONSTRAINT "FK_CVTHUOCNHOM" FOREIGN KEY ("MANHOM")
	  REFERENCES "NHOM" ("MANHOM") ENABLE;
--------------------------------------------------------
--  Constraints for Table THUCHIEN
--------------------------------------------------------

  ALTER TABLE "THUCHIEN" ADD CONSTRAINT "PK_THUCHIEN" PRIMARY KEY ("EMAIL_TV", "MACV_PC", "MANHOM")
  USING INDEX  ENABLE;
  ALTER TABLE "THUCHIEN" MODIFY ("EMAIL_TV" NOT NULL ENABLE);
  ALTER TABLE "THUCHIEN" MODIFY ("MACV_PC" NOT NULL ENABLE);
  ALTER TABLE "THUCHIEN" MODIFY ("MANHOM" NOT NULL ENABLE);
  ALTER TABLE "THUCHIEN" MODIFY ("TRANGTHAI" NOT NULL ENABLE);
  ALTER TABLE "THUCHIEN" ADD CONSTRAINT "FK_TV_DC_PC" FOREIGN KEY ("EMAIL_TV")
	  REFERENCES "NGUOIDUNG" ("EMAILND") ENABLE;
  ALTER TABLE "THUCHIEN" ADD CONSTRAINT "FK_CVPC" FOREIGN KEY ("MACV_PC")
	  REFERENCES "CONGVIEC" ("MACV") ENABLE;
---------------------------------------------------------------------------------------------------
--TRIGGER
--CHECK_NGAYBD_CONGVIEC
CREATE OR REPLACE TRIGGER TRIGGER_CHECK_NGAYBD
BEFORE INSERT OR UPDATE ON CONGVIEC
FOR EACH ROW
BEGIN
    IF (:NEW.NGAYBD <= CURRENT_DATE) THEN
        raise_application_error(-20001, 'Thoi gian bat dau khong the nho hon thoi gian hien tai');
    END IF;
END;

----------------------------------------------------------------------------------------------------
--CHECK_NGAYKT_CONGVIEC
CREATE OR REPLACE TRIGGER TRIGGER_CHECK_NGAYKT
BEFORE INSERT OR UPDATE ON CONGVIEC
FOR EACH ROW
BEGIN
    IF (:NEW.NGAYKT <= :NEW.NGAYBD) THEN
        raise_application_error(-20001, 'Thoi gian ket thuc khong the nho hon hoac bang thoi gian bat dau cong viec');
    END IF;
END;
---------------------------------------------------------------------------------------------------

-- PROCEDURE
-- XEM CONG VIEC CO TRANG THAI DANG LAM
CREATE OR REPLACE PROCEDURE pc_xemcvdanglam IS
BEGIN
    FOR cv_danglam IN (SELECT nh.TENNHOM, cv.TENCV, cv.LINHVUC, cv.MOTACV, cv.NGAYBD, cv.NGAYKT, cv.MUC_UUTIEN
                        FROM CONGVIEC cv
                        JOIN NHOM nh ON cv.MANHOM = nh.MANHOM
                        JOIN THUCHIEN th ON cv.MACV = th.MACV_PC AND cv.MANHOM = th.MANHOM
                        WHERE th.TRANGTHAI = '?ang l�m') 
    LOOP
        -- Xu ly in ra muc do uu ti�n
        DECLARE 
            muc_uutien_str VARCHAR2(20);
        BEGIN
            IF cv_danglam.MUC_UUTIEN = 1 THEN
                muc_uutien_str := 'C?n g?p';
            ELSIF cv_danglam.MUC_UUTIEN = 2 THEN
                muc_uutien_str := 'Quan tr?ng';
            ELSE
                muc_uutien_str := 'Th??ng';
            END IF;
            
            -- In ra thong tin cv 
            DBMS_OUTPUT.PUT_LINE('Ten nhom: ' || cv_danglam.TENNHOM);
            DBMS_OUTPUT.PUT_LINE('Ten cong viec: ' || cv_danglam.TENCV);
            DBMS_OUTPUT.PUT_LINE('Linh vuc: ' || cv_danglam.LINHVUC);
            DBMS_OUTPUT.PUT_LINE('Mo ta: ' || cv_danglam.MOTACV);
            DBMS_OUTPUT.PUT_LINE('Ngay bat dau: ' || TO_CHAR(cv_danglam.NGAYBD, 'DD-MON-YY'));
            DBMS_OUTPUT.PUT_LINE('Ngay ket thuc: ' || TO_CHAR(cv_danglam.NGAYKT, 'DD-MON-YY'));
            DBMS_OUTPUT.PUT_LINE('Muc uu tien: ' || muc_uutien_str);
            DBMS_OUTPUT.PUT_LINE('-------------------------');
        END;
    END LOOP;
END;
/
set serveroutput on;
execute pc_xemcvdanglam;

----------------------------------------------------------------------------------
--Xem cong viec can lam
CREATE OR REPLACE PROCEDURE pc_xemcvcanlam IS
BEGIN
    FOR cv_selam IN (SELECT nh.TENNHOM, cv.TENCV, cv.LINHVUC, cv.MOTACV, cv.NGAYBD, cv.NGAYKT, cv.MUC_UUTIEN
                        FROM CONGVIEC cv
                        JOIN NHOM nh ON cv.MANHOM = nh.MANHOM
                        JOIN THUCHIEN th ON cv.MACV = th.MACV_PC AND cv.MANHOM = th.MANHOM
                        WHERE th.TRANGTHAI = 'C?n l�m') 
    LOOP
        -- X? l� in ra m?c ?? ?u ti�n
        DECLARE muc_uutien_str VARCHAR2(20);
        BEGIN
            IF cv_selam.MUC_UUTIEN = 1 THEN
                muc_uutien_str := 'C?n g?p';
            ELSIF cv_selam.MUC_UUTIEN = 2 THEN
                muc_uutien_str := 'Quan tr?ng';
            ELSE
                muc_uutien_str := 'Th??ng';
            END IF;
            
            -- In ra th�ng tin c�ng viec
            DBMS_OUTPUT.PUT_LINE('Ten nhom: ' || cv_selam.TENNHOM);
            DBMS_OUTPUT.PUT_LINE('Ten cong viec: ' || cv_selam.TENCV);
            DBMS_OUTPUT.PUT_LINE('Linh vuc: ' || cv_selam.LINHVUC);
            DBMS_OUTPUT.PUT_LINE('Mo ta: ' || cv_selam.MOTACV);
            DBMS_OUTPUT.PUT_LINE('Ngay bat dau: ' || TO_CHAR(cv_selam.NGAYBD, 'DD-MON-YY'));
            DBMS_OUTPUT.PUT_LINE('Ngay ket thuc: ' || TO_CHAR(cv_selam.NGAYKT, 'DD-MON-YY'));
            DBMS_OUTPUT.PUT_LINE('Muc do uu tien: ' || muc_uutien_str);
            DBMS_OUTPUT.PUT_LINE('-------------------------');
        END;
    END LOOP;
END;
/
set serveroutput on;
execute pc_xemcvcanlam;
------------------------------------------------------------------------------
-- KIEM TRA CV HET HAN
CREATE OR REPLACE PROCEDURE pc_ktcv (
    p_macv_pc IN THUCHIEN.MACV_PC%TYPE
)
IS
    v_ngaykt DATE;
    v_message VARCHAR2(50);
BEGIN
    -- Lay ngay KT cua CV tai bang THUCHIEN
    SELECT cv.NGAYKT
    INTO v_ngaykt
    FROM CONGVIEC cv
    JOIN THUCHIEN th ON cv.MACV = th.MACV_PC
    WHERE th.MACV_PC = p_macv_pc;
    
    -- So s�nh ng�y ket th�c voi ng�y hien tai
    IF v_ngaykt < SYSDATE THEN
        v_message := 'Cong viec da qua han nop';
    ELSIF v_ngaykt = TRUNC(SYSDATE) THEN
        v_message := 'Cong viec den han nop';
    ELSE
        v_message := 'Cong viec chua den han nop';
    END IF;
    
    -- In ra thong bao
    DBMS_OUTPUT.PUT_LINE(v_message);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Khong tim thay cong viec voi ma: ' || p_macv_pc);
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Loi xay ra: ' || SQLERRM);
END pc_ktcv;
/
SET SERVEROUTPUT ON;
EXECUTE pc_ktcv('1');

--THEM THANH VIEN VAO NHOM
CREATE OR REPLACE PROCEDURE pc_themtvvaonhom(
    p_emailnd NGUOIDUNG.EMAILND%TYPE,
    p_manhom NHOM.MANHOM%TYPE,
    p_message OUT VARCHAR2
) AS
    v_count NUMBER;
BEGIN
    -- Kt thanh vien va ma nhom co ton tai trong bang NGUOIDUNG va NHOM ko
    SELECT COUNT(*)
    INTO v_count
    FROM NGUOIDUNG
    WHERE EMAILND = p_emailnd;

    IF v_count = 0 THEN
        p_message := 'Them khong thanh cong. Email khong ton tai.';
        RETURN;
    END IF;

    SELECT COUNT(*)
    INTO v_count
    FROM NHOM
    WHERE MANHOM = p_manhom;

    IF v_count = 0 THEN
        p_message := 'Them thanh vien khong thanh cong. Ma nhom khong ton tai.';
        RETURN;
    END IF;

    -- Kt tv da ton tai trong nhom chua
    SELECT COUNT(*)
    INTO v_count
    FROM NGUOIDUNG_NHOM
    WHERE EMAILND = p_emailnd AND MANHOM = p_manhom;

    IF v_count > 0 THEN
        p_message := 'Them khong thanh cong. Thanh vien da ton tai trong nhom.';
        RETURN;
    END IF;

    -- Them thanh vien vao nhom
    INSERT INTO NGUOIDUNG_NHOM (EMAILND, MANHOM)
    VALUES (p_emailnd, p_manhom);

    p_message := 'Them thanh vien vao nhom thanh cong.';
EXCEPTION
    WHEN OTHERS THEN
        p_message := 'Them thanh vien khong thanh cong. Loi: ' || SQLERRM;
END;
/
 SET SERVEROUTPUT ON;
DECLARE
  v_message VARCHAR2(200);
BEGIN
  pc_themtvvaonhom('example@email.com', '1', v_message);
  DBMS_OUTPUT.PUT_LINE(v_message);
END;
/
-------------------------------------------------------------------------------
-- XOA THANH VIEN KHOI NHOM
CREATE OR REPLACE PROCEDURE pc_xoatvvkhoinhom (
    p_email VARCHAR2,
    p_manhom VARCHAR2,
    p_message OUT VARCHAR2
) AS
    v_count NUMBER;
BEGIN
    -- Kt xem thanh vien co trong nhom khong
    SELECT COUNT(*)
    INTO v_count
    FROM NGUOIDUNG_NHOM
    WHERE EMAILND = p_email AND MANHOM = p_manhom;

    IF v_count = 0 THEN
        p_message := 'Thanh vien khong ton tai trong nhom.';
    ELSE
        -- Xoa thanh vien khoi nhom
        DELETE FROM NGUOIDUNG_NHOM
        WHERE EMAILND = p_email AND MANHOM = p_manhom;

        --xoa thong tin phan cong cua thanh vien
        DELETE FROM THUCHIEN
        WHERE EMAIL_TV = p_email AND MANHOM = p_manhom;

        p_message := 'Xoa thanh vien khoi nhom thanh cong.';
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        p_message := 'Da xay ra loi ' || SQLERRM;
END;
/
DECLARE
    v_message VARCHAR2(200);
BEGIN
    pc_xoatvvkhoinhom('example@email.com', '1', v_message);
    DBMS_OUTPUT.PUT_LINE(v_message);
END;
/

----------------------------------------------------------------------
----------------------------------------------------------------------
-------------------------FUNCTION--------------------------------------
-- THONG KE SL CONG VIEC CO TRANG THAI DA HOAN THANH
CREATE OR REPLACE FUNCTION fc_slcvdahoanthanh(
    p_manhom IN VARCHAR2
) RETURN NUMBER
IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM THUCHIEN
    WHERE MANHOM = p_manhom
    AND TRANGTHAI = '?� ho�n th�nh';

    RETURN v_count;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END;
/
DECLARE
    v_count NUMBER;
BEGIN
    v_count := fc_slcvdahoanthanh(1);
    DBMS_OUTPUT.PUT_LINE('SL cong viecc da hoan thanh: ' || v_count);
END;
/
----------------------------------------------------------------------------
-- THONG KE SL CONG VIEC CO TRANG THAI DANG LAM
CREATE OR REPLACE FUNCTION fc_slcvdanglam(
    p_manhom IN VARCHAR2
) RETURN NUMBER IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM THUCHIEN
    WHERE MANHOM = p_manhom AND TRANGTHAI = '?ang l�m';

    RETURN v_count;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END fc_slcvdanglam;
/
DECLARE
    v_count NUMBER;
BEGIN
    v_count := fc_slcvdanglam(2);
    DBMS_OUTPUT.PUT_LINE('SL cong viec dang lam: ' || v_count);
END;
/
--THONG KE SL CONG VIEC CAN LAM -------------------------------------------
CREATE OR REPLACE FUNCTION fc_slcvcanlam(
    p_manhom IN VARCHAR2
) RETURN NUMBER IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO v_count
    FROM THUCHIEN
    WHERE MANHOM = p_manhom AND TRANGTHAI = 'C?n l�m';

    RETURN v_count;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 0;
END fc_slcvcanlam;
/
DECLARE
    v_slcv NUMBER;
BEGIN
    v_slcv := fc_slcvcanlam(1);

    DBMS_OUTPUT.PUT_LINE('SL cong viec can lam: ' || v_slcv);
END;
/
----------------------------------------------------------------------------------------------------
-- PROCEDURE
-- THEM NGUOI DUNG
CREATE OR REPLACE PROCEDURE THEM_USER (
    I_EMAIL IN NGUOIDUNG.EMAILND%TYPE, 
    I_TENUSER IN NGUOIDUNG.TENND%TYPE, 
    I_MATKHAU IN NGUOIDUNG.MATKHAU%TYPE
)
IS
BEGIN
    INSERT INTO NGUOIDUNG (EMAILND, TENND, MATKHAU) 
    VALUES (I_EMAIL, I_TENUSER, I_MATKHAU);
    DBMS_OUTPUT.PUT_LINE('Them user thanh cong');
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Email da ton tai');
END;

-- CAP NHAT NGUOI DUNG
create or replace PROCEDURE CAPNHAT_NGUOIDUNG (
    I_EMAIL IN NGUOIDUNG.EMAILND%TYPE, 
    I_TENUSER IN NGUOIDUNG.TENND%TYPE, 
    I_MATKHAU IN NGUOIDUNG.MATKHAU%TYPE, 
    I_MANHOM IN NGUOIDUNG_NHOM.MANHOM%TYPE
)
IS
BEGIN
    UPDATE NGUOIDUNG
    SET TENND = I_TENUSER, MATKHAU = I_MATKHAU
    WHERE EMAILND = I_EMAIL;
    IF SQL%NOTFOUND THEN
        DBMS_OUTPUT.PUT_LINE('User khong ton tai');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Cap nhat user thanh cong');
    END IF;
END;
------------------------------------------------------------------------
-- XOA EMAIL TRONG BANG THUC HIEN
CREATE OR REPLACE PROCEDURE XOA_THUCHIEN_THEO_EMAIL (
    I_EMAIL IN NGUOIDUNG.EMAILND%TYPE
)
IS
BEGIN
    DELETE FROM THUCHIEN
    WHERE EMAIL_TV = I_EMAIL;
    DBMS_OUTPUT.PUT_LINE('');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('');
END;
--------------------------------------------------------------------------
-- XOA EMAIL TRONG BANG GHI LIEN QUAN
CREATE OR REPLACE PROCEDURE XOA_NHOM_THEO_EMAIL (
    I_EMAIL IN NGUOIDUNG.EMAILND%TYPE
)
IS
BEGIN
    -- X�a c�c c�ng vi?c thu?c nh�m
    DELETE FROM CONGVIEC
    WHERE MANHOM = (SELECT MANHOM FROM NGUOIDUNG_NHOM WHERE EMAILND = I_EMAIL);
    -- X�a c�c b?n ghi trong b?ng THUCHIEN li�n k?t v?i nh�m
    DELETE FROM THUCHIEN
    WHERE MANHOM = (SELECT MANHOM FROM NGUOIDUNG_NHOM WHERE EMAILND = I_EMAIL);

    DELETE FROM NHOM
    WHERE EMAIL_TRUONGNHOM = I_EMAIL;

    DELETE FROM NGUOIDUNG_NHOM
    WHERE EMAILND = I_EMAIL;
    DBMS_OUTPUT.PUT_LINE('Xoa tat ca cac ban ghi trong bang NHOM lien quan den nguoi dung co email ' || I_EMAIL || ' thanh cong');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('User khong ton tai');
END;
--------------------------------------------------------------------------
--XOA NGUOI DUNG
CREATE OR REPLACE PROCEDURE XOA_NGUOIDUNG (
    I_EMAIL IN NGUOIDUNG.EMAILND%TYPE
)
IS
    L_EMAIL NGUOIDUNG.EMAILND%TYPE;
BEGIN
    SELECT EMAILND INTO L_EMAIL
    FROM NGUOIDUNG
    WHERE EMAILND = I_EMAIL;

    IF L_EMAIL IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('User khong ton tai');
    ELSE
        -- X�a t?t c? c�c b?n ghi li�n quan ??n ng??i d�ng n�y tr??c
        XOA_THUCHIEN_THEO_EMAIL(I_EMAIL);
        XOA_NHOM_THEO_EMAIL(I_EMAIL);
        XOA_NHOM_THEO_EMAIL(I_EMAIL);

        -- Sau ?�, ti?n h�nh x�a ng??i d�ng
        DELETE FROM NGUOIDUNG
        WHERE EMAILND = I_EMAIL;
        DBMS_OUTPUT.PUT_LINE('Xoa user thanh cong');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('User khong ton tai');

END;
-----------------------------------------------------------------------------
-- THEM CONG VIEC
CREATE OR REPLACE PROCEDURE THEM_CONGVIEC (
    I_TENCV IN CONGVIEC.TENCV%TYPE,
    I_MANHOM IN CONGVIEC.MANHOM%TYPE,
    I_LINHVUC IN CONGVIEC.LINHVUC%TYPE,
    I_MOTACV IN CONGVIEC.MOTACV%TYPE,
    I_MUC_UUTIEN IN CONGVIEC.MUC_UUTIEN%TYPE,
    I_NGAYBD IN CONGVIEC.NGAYBD%TYPE,
    I_NGAYKT IN CONGVIEC.NGAYKT%TYPE
)
IS
    I_MACV NUMBER; -- Khai b�o bi?n I_MACV ? ?�y
BEGIN
    -- them macv tu dong
    SELECT NVL(MAX(MACV), 0) + 1 INTO I_MACV FROM CONGVIEC;
    
    INSERT INTO CONGVIEC (MACV, MANHOM, TENCV, LINHVUC, MOTACV, MUC_UUTIEN, NGAYBD, NGAYKT) 
    VALUES (I_MACV, I_MANHOM, I_TENCV, I_LINHVUC, I_MOTACV, I_MUC_UUTIEN, I_NGAYBD, I_NGAYKT);
    DBMS_OUTPUT.PUT_LINE('Them cong viec thanh cong');
END;

-----------------------------------------------------------------------------------------------------------------
--CAP NHAT CONG VIEC
create or replace PROCEDURE CAPNHAT_CONGVIEC (
    P_MACV IN CONGVIEC.MACV%TYPE,
    P_TENCV IN CONGVIEC.TENCV%TYPE,
    P_MANHOM IN CONGVIEC.MANHOM%TYPE,
    P_LINHVUC IN CONGVIEC.LINHVUC%TYPE,
    P_MOTACV IN CONGVIEC.MOTACV%TYPE,
    P_MUC_UUTIEN IN CONGVIEC.MUC_UUTIEN%TYPE,
    P_NGAYBD IN CONGVIEC.NGAYBD%TYPE,
    P_NGAYKT IN CONGVIEC.NGAYKT%TYPE
)
AS
BEGIN
    UPDATE CONGVIEC
    SET TENCV = P_TENCV,
        MANHOM = P_MANHOM,
        LINHVUC = P_LINHVUC,
        MOTACV = P_MOTACV,
        MUC_UUTIEN = P_MUC_UUTIEN,
        NGAYBD = P_NGAYBD,
        NGAYKT = P_NGAYKT
    WHERE MACV = P_MACV;
    IF SQL%NOTFOUND THEN
        DBMS_OUTPUT.PUT_LINE('Cong viec khong ton tai');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Cap nhat cong viec thanh cong');
    END IF;
END;

------------------------------------------------------------------------------------------------------
--CAP NHAT TRANG  THAI CONG VIEC
create or replace PROCEDURE CAPNHAT_TRANGTHAI_CONGVIEC (
    P_MACV_PC THUCHIEN.MACV_PC%TYPE,
    P_TRANGTHAI THUCHIEN.TRANGTHAI%TYPE
)
IS 
    L_MACV VARCHAR2(30);
BEGIN
    SELECT MACV_PC INTO L_MACV
    FROM THUCHIEN
    WHERE MACV_PC = P_MACV_PC;
    IF L_MACV IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('Cong viec khong ton tai');
    ELSE
        UPDATE THUCHIEN
        SET TRANGTHAI = P_TRANGTHAI
        WHERE MACV_PC = P_MACV_PC;
        DBMS_OUTPUT.PUT_LINE('Cap nhat trang thai thanh cong');
    END IF;
    EXCEPTION WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Cong viec khong ton tai');
END;
--------------------------------------------------------------------
-- XEM CONG VIEC CO TRANG THAI DA LAM
create or replace PROCEDURE XEM_CONGVIEC_DA_LAM 
AS
BEGIN
    FOR rec IN (
        SELECT CV.MACV, CV.TENCV, CV.LINHVUC
        FROM CONGVIEC CV
        JOIN THUCHIEN TH ON CV.MACV = TH.MACV_PC
        WHERE TH.TRANGTHAI = '?� ho�n th�nh'
        )
    LOOP
        DBMS_OUTPUT.PUT_LINE('Ma cong viec: ' || rec.MACV || ', Ten cong viec: ' || rec.TENCV || ', Linh vuc: ' || rec.LINHVUC);
    END LOOP;
END;

-------------------------------------------------------------------------
-- XOA NGUOI DUNG BANG EMAIL KHOI CAC BANG LIEN QUAN
CREATE OR REPLACE PROCEDURE pc_xoaND (
    p_email IN VARCHAR2
) IS
BEGIN
    -- X�a ng??i d�ng kh?i b?ng THUCHIEN
    DELETE FROM THUCHIEN
    WHERE EMAIL_TV = p_email;

    -- X�a ng??i d�ng kh?i b?ng NGUOIDUNG_NHOM
    DELETE FROM NGUOIDUNG_NHOM
    WHERE EMAILND = p_email;

    -- X�a ng??i d�ng kh?i b?ng NGUOIDUNG
    DELETE FROM NGUOIDUNG
    WHERE EMAILND = p_email;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('?� x�a ng??i d�ng v� c�c th�ng tin li�n quan: ' || p_email);
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/

