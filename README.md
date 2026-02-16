# Plaster Calculator（石膏量計算ツール）

## 概要
石膏クラフト制作時に必要な  
**石膏と水の量を自動計算するツール**です。

モールドの形状・サイズ・個数・ロス率を入力すると、  
実制作に即した材料量を算出します。

---

## 解決したい課題
- 手計算が面倒で時間がかかる  
- 計算ミスによる材料不足が起きる  
- ロス分や中空構造を考慮しにくい  

→ これらを **シンプルな入力だけで解決** します。

---

## 主な機能

### 基本機能
- 円柱・円錐・直方体などの体積計算  
- 五角形・六角形など多角形形状への対応  
- 星型・ハート型・雲型など複雑形状の近似計算  
- 石膏：水 比率入力  
- ロス率を含めた必要量算出  
- 単位切替（mm / cm）  

### 中空構造への対応
- 外形体積 − 内形体積 による**中空計算**  
- ペン立て・小物入れ・キャンドルホルダー・縁付きトレー等を想定  
- 内側サイズ入力による実制作ベースの材料算出  

---

## 将来予定の高度機能
- 画像やSVGからの**面積自動計算**  
- 任意形状モールドへの対応  
- 設定保存・履歴管理  
- スマホ対応（PWA）  
- データベース連携  

---

## 使用技術

### 現在
- Excel（仕様設計・計算ロジック整理）

### 今後実装予定
- HTML / CSS / JavaScript  
- Python（Flask）  
- Git / GitHub  

---

## 使い方（予定）

1. モールドの外形を選択  
2. サイズ・個数・ロス率を入力  
3. 必要に応じて中空サイズを入力  
4. 石膏：水の比率を入力  
5. 必要材料量が自動表示される  

---

## ロードマップ

- [ ] Excel仕様完成  
- [ ] Webアプリ（JavaScript）実装  
- [ ] Flaskによるバックエンド化  
- [ ] 中空計算UIの完成  
- [ ] 画像から面積計算機能の実装  
- [ ] スマホ最適化（PWA）  

---

## 制作背景
石膏クラフト制作の実体験から、  
**実用的な材料計算ツールを作りたい**と考え本プロジェクトを開始しました。

実用性と技術学習を両立した  
ポートフォリオ作品として開発を進めています。

---

## 作者
- Name: Nana Matsumoto  
- GitHub: to be added





# Plaster Calculator

## Overview
This tool automatically calculates the required amounts of **plaster and water** for plaster craft projects.

By entering the mold shape, size, quantity, and loss rate,  
the app outputs material amounts suitable for real production.

---

## Problems This Project Solves
- Manual calculations are time-consuming  
- Risk of material shortage due to miscalculation  
- Difficult to account for **loss and hollow structures**  

→ Solved with **simple inputs and automatic calculation**.

---

## Main Features

### Core Features
- Volume calculation for cylinders, cones, and rectangular prisms  
- Support for polygons such as pentagons and hexagons  
- Approximation for complex shapes like stars, hearts, and clouds  
- Custom plaster-to-water ratio input  
- Loss-adjusted material calculation  
- Unit switching (mm / cm)

### Hollow Structure Support
- **Outer volume − inner volume** hollow calculation  
- Designed for pen holders, containers, candle holders, and rimmed trays  
- Inner dimension input for production-accurate material estimation  

---

## Planned Advanced Features
- **Automatic area calculation from images or SVG**  
- Support for fully custom mold shapes  
- Preset saving and history management  
- Mobile support (PWA)  
- Database integration  

---

## Tech Stack

### Current
- Excel (specification and calculation design)

### Planned Implementation
- HTML / CSS / JavaScript  
- Python (Flask)  
- Git / GitHub  

---

## How to Use (planned)

1. Select the outer mold shape  
2. Enter size, quantity, and loss rate  
3. Input inner dimensions if hollow  
4. Set the plaster-to-water ratio  
5. Required material amounts are calculated automatically  

---

## Roadmap

- [ ] Complete Excel specification  
- [ ] Implement web app in JavaScript  
- [ ] Add Flask backend  
- [ ] Finalize hollow-calculation UI  
- [ ] Implement image-based area calculation  
- [ ] Optimize for mobile (PWA)  

---

## Background
This project began from real experience in plaster craft production,  
aiming to create a **practical material calculation tool**.

It is also developed as a portfolio project  
to build real-world web development skills.

---

## Author
- Name: Nana Matsumoto  
- GitHub: to be added