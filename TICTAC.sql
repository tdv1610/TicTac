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
INSERT INTO AD VALUES ('22521455@gm.uit.edu.vn', 'Hoàng D??ng Ng?c Th?y', '2252thuy');
INSERT INTO AD VALUES ('khanhphuong06@gmail.com', 'Tr?n Khánh Ph??ng', '062004');
INSERT INTO AD VALUES ('quocanhle@gmail.com', 'Lê Nguy?n Qu?cc Anh', 'anhle2222');
INSERT INTO AD VALUES ('ngocanhnguyen@gmail.com', 'Nguy?n Lê Ng?c Anh', 'ahihihi');

REM INSERTING into NGUOIDUNG
SET DEFINE OFF;
INSERT INTO NGUOIDUNG VALUES ('22521366@gm.uit.edu.vn', 'Thanh Tr?n', '1366thanh');
INSERT INTO NGUOIDUNG VALUES ('phongle@gmail.com', 'Lê Thanh Phong', '246810phong');
INSERT INTO NGUOIDUNG VALUES ('baonhanxyz@gmail.com', 'Nhân Lê', 'abcd1234');
INSERT INTO NGUOIDUNG VALUES ('thuytrang004@gmail.com', 'Trang', 'tttranggg');

REM INSERTING into NGUOIDUNG_NHOM
SET DEFINE OFF;
INSERT INTO NGUOIDUNG_NHOM VALUES ('22521366@gm.uit.edu.vn','1');
INSERT INTO NGUOIDUNG_NHOM VALUES ('phongle@gmail.com', '1');
INSERT INTO NGUOIDUNG_NHOM VALUES ('baonhanxyz@gmail.com', '2');
INSERT INTO NGUOIDUNG_NHOM VALUES ('thuytrang004@gmail.com','2');

REM INSERTING into NHOM
SET DEFINE OFF;
INSERT INTO NHOM VALUES ('1', 'Ch?y ?? án sml', '22521366@gm.uit.edu.vn');
INSERT INTO NHOM VALUES ('2', 'Ôn thi sml', 'thuytrang004@gmail.com');

REM INSERTING into CONGVIEC
SET DEFINE OFF;
INSERT INTO CONGVIEC VALUES ('1', '1', 'T?o giao di?n ?? án', 'CNTT', 'T?o b?ng Java Swing', 1, '01-MAY-24', '15-MAY-24');
INSERT INTO CONGVIEC VALUES ('2', '1', 'T?o database', 'CNTT', 'T?o trong Oracle', 1, '10-MAY-24', '15-MAY-24');
INSERT INTO CONGVIEC VALUES ('3', '1', 'H?c SD Github', 'CNTT', 'T? tìm ki?m ngu?n h?c', 3, '01-MAY-24', '16-MAY-24');
INSERT INTO CONGVIEC VALUES ('4', '2', 'Ôn thi CK HDH', 'CNTT', 'Tìm tài li?u ôn', 2, '15-MAY-24', '16-JUN-24');
INSERT INTO CONGVIEC VALUES ('5', '2', 'L?y g?c HQTCSDL', 'CSDL', 'Tìm bài gi?ng', 2, '10-MAY-24', '15-JUN-24');

REM INSERTING into THUCHIEN
SET DEFINE OFF;
INSERT INTO THUCHIEN VALUES ('22521366@gm.uit.edu.vn', '1','1', 'C?n làm');
INSERT INTO THUCHIEN VALUES ('22521366@gm.uit.edu.vn', '3','1', 'C?n làm');
INSERT INTO THUCHIEN VALUES ('phongle@gmail.com', '2','1' ,'C?n làm');
INSERT INTO THUCHIEN VALUES ('baonhanxyz@gmail.com', '4','2', 'C?n làm');
INSERT INTO THUCHIEN VALUES ('thuytrang004@gmail.com', '5','2', '?ang làm');
--------------------------------------------------------------------------------
--  Constraints for Table AD
--------------------------------------------------------

  ALTER TABLE "AD" ADD CONSTRAINT "PK_AD" PRIMARY KEY ("EMAILAD")
  USING INDEX  ENABLE;
  ALTER TABLE "AD" MODIFY ("EMAILAD" NOT NULL ENABLE);
  ALTER TABLE "AD" MODIFY ("TENAD" NOT NULL ENABLE);
  ALTER TABLE "AD" MODIFY ("MATKHAU" NOT NULL ENABLE);


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

---------------------------------------------------------------------------------------------------

-- PROCEDURE
-- XEM CONG VIEC CO TRANG THAI DANG LAM
CREATE OR REPLACE PROCEDURE pc_xemcvdanglam IS
BEGIN
    FOR cv_danglam IN (SELECT nh.TENNHOM, cv.TENCV, cv.LINHVUC, cv.MOTACV, cv.NGAYBD, cv.NGAYKT, cv.MUC_UUTIEN
                        FROM CONGVIEC cv
                        JOIN NHOM nh ON cv.MANHOM = nh.MANHOM
                        JOIN THUCHIEN th ON cv.MACV = th.MACV_PC AND cv.MANHOM = th.MANHOM
                        WHERE th.TRANGTHAI = '?ang làm') 
    LOOP
        -- Xu ly in ra muc do uu tiên
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
            DBMS_OUTPUT.PUT_LINE('Tên nhóm: ' || cv_danglam.TENNHOM);
            DBMS_OUTPUT.PUT_LINE('Tên công vi?c: ' || cv_danglam.TENCV);
            DBMS_OUTPUT.PUT_LINE('L?nh v?c: ' || cv_danglam.LINHVUC);
            DBMS_OUTPUT.PUT_LINE('Mô t?: ' || cv_danglam.MOTACV);
            DBMS_OUTPUT.PUT_LINE('Ngày b?t ??u: ' || TO_CHAR(cv_danglam.NGAYBD, 'DD-MON-YY'));
            DBMS_OUTPUT.PUT_LINE('Ngày k?t thúc: ' || TO_CHAR(cv_danglam.NGAYKT, 'DD-MON-YY'));
            DBMS_OUTPUT.PUT_LINE('M?c ?? ?u tiên: ' || muc_uutien_str);
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
                        WHERE th.TRANGTHAI = 'C?n làm') 
    LOOP
        -- X? lý in ra m?c ?? ?u tiên
        DECLARE muc_uutien_str VARCHAR2(20);
        BEGIN
            IF cv_selam.MUC_UUTIEN = 1 THEN
                muc_uutien_str := 'C?n g?p';
            ELSIF cv_selam.MUC_UUTIEN = 2 THEN
                muc_uutien_str := 'Quan tr?ng';
            ELSE
                muc_uutien_str := 'Th??ng';
            END IF;
            
            -- In ra thông tin công viec
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
    
    -- So sánh ngày ket thúc voi ngày hien tai
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
    AND TRANGTHAI = '?ã hoàn thành';

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
    WHERE MANHOM = p_manhom AND TRANGTHAI = '?ang làm';

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
    WHERE MANHOM = p_manhom AND TRANGTHAI = 'C?n làm';

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


