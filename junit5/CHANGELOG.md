# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

_No unreleased changes_

## [1.1.0] - 2020-03-18

### Added
- `MockkClearUnmockExtension` is the new name of `MockkExtension`.

### Deprecated
- `MockkExtension` has been deprecated (warning), but still exists for forward compatibility.

### Changed
- `ExampleTestSuite` uses `MockkClearUnmockExtension`.

## [1.0.0] - 2020-03-15

### Added

- `MockkClearExtension` to clear all MockK mocks after each unit test
- `MockkUnmockExtension` to unmock all MockK mocks after a test class
- `MockkExtension` to automatically apply `MockkClearExtension` and `MockkUnmockExtension`
- Example tests for `MockkExtension`
- CHANGELOG.md
- README.md
