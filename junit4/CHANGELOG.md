# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- CHANGELOG.md
- README.md

### Changed

- Improved documentation

## [1.0.0-alpha] - 2020-03-12

### Added

- 🎉 Initial alpha release
- JUnit 4 module
  - `MockkTestClassRule` to unmock all MockK mocks after a test class
  - `MockkTestRule` to clear all MockK mocks after a unit test
  - `MockkTest`, a class to extend that applies `MockkTestClassRule` and `MockkTestRule` automatically.
