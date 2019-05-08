# 概要
## アプリケーション
- クイズを解く時間を競うアプリケーション
- クイズはたくさんあり、ユーザーは好きなクイズに参加できる
- クイズに参加するまで内容(問題)は見ることができない

## ユースケース
- ユーザーがプロジェクトに参加する
- ユーザーは答えを送る
- ユーザーは先ほど送った答えの合否を見る
- ユーザーはクイズの順位表を見る

## ツール
Java8
Spring Boot
Gradle
MySQL

# ディレクトリ構成
```
quiz-webapi/
├── README.md
└── src/main/java/quiz
    ├── application        <- インターフェース
    │   ├── controller
    │   └── resources
    │
    ├── domain             <- ビジネスロジック
    │   ├── object      <- モデル
    │   ├── repository  <- interfaceのみ。infrastructureで実装
    │   └── service     <- ビジネスロジック
    │
    └── infrastructure     <- DB接続
        ├── entity      <- DBテーブル・カラムのマッピング
        └── repository  <- リポジトリ
```

# TODO
 - チェック処理
 - ログ出力
 - 例外処理
 - (認証処理)

