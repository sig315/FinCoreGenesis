# FinCoreGenesis

## 概要

FinCoreGenesisは、JavaとSpring Bootを用いて開発している口座管理システムです。

本プロジェクトは、要件定義から設計・実装・テストまでの一連の開発工程を経験し、
ポートフォリオとして公開することを目的としています。

## 使用技術

### バックエンド
- Java 21
- Spring Boot
- Spring Data JPA

### フロントエンド
- HTML
- CSS
- Thymeleaf

### データベース
- MySQL

### データベース管理ツール
- MySQL Workbench

### ビルドツール
- Maven

### 開発環境
- IntelliJ IDEA
- Git
- GitHub

## システム機能

### 実装済み

- ユーザー登録画面
- ユーザー登録機能
- MySQL接続

### 実装予定

- ログイン
- ログアウト
- 口座登録
- 口座一覧
- 口座詳細
- 口座編集
- 口座削除
- 入金
- 出金

## プロジェクト構成

```text
FinCoreGenesis
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │       ├── static
│   │       ├── templates
│   │       └── application.yml
│   └── test
├── .gitignore 
├── pom.xml
├── README.md
└── .gitignore
```

### ディレクトリ概要

|ディレクトリ|内容|
|---|---|
|src/main/java|Javaソースコード（Controller、Service、Repository、Entityなど）|
|src/main/resources/templates|Thymeleafテンプレート（HTML）|
|src/main/resources/static|CSS・JavaScript・画像などの静的ファイル|
|src/test|テストコード|
|pom.xml|Maven依存関係・ビルド設定|
|README.md|プロジェクト概要|

