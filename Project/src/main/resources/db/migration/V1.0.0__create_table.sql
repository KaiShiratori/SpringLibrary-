-- テーブルが重複しないよう存在チェック、あれば削除します
DROP TABLE IF EXISTS library;

-- 簡易な図書マスタテーブル
CREATE TABLE `library` (
  `id` long unsigned NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  `start_Date` DATE NOT NULL,
  PRIMARY KEY (`id`)
);
