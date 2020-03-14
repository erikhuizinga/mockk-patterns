# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added

- JUnit 5 module
  - `MockkClearExtension` to clear all MockK mocks after each unit test
  - `MockkUnmockExtension` to unmock all MockK mocks after a test class
  - `MockkExtension` to automatically apply `MockkClearExtension` and `MockkUnmockExtension`
- CHANGELOG.md
- README.md
