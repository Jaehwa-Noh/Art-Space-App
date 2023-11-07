//
//  ArtSpaceAppTests.swift
//  ArtSpaceAppTests
//
//  Created by Jaehwa Noh on 11/7/23.
//

import XCTest
@testable import ArtSpaceApp

final class ArtSpaceAppTests: XCTestCase {
    
    var nextAndPreviousButtonView: NextAndPreviousButton?

    override func setUpWithError() throws {
        try super.setUpWithError()
        nextAndPreviousButtonView = NextAndPreviousButton(currentPage: .constant(0))
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        nextAndPreviousButtonView = nil
        try super.tearDownWithError()
    }
    
    func testNextButton_2To0() {
        let isNext = true
        var currentPage = 2
        currentPage = nextAndPreviousButtonView!.updateCurrentPage(isNext: isNext, currentPage: currentPage)
        XCTAssertEqual(0, currentPage)
    }
    
    func testNextButton_0To1() {
        let isNext = true
        var currentPage = 0
        currentPage = nextAndPreviousButtonView!.updateCurrentPage(isNext: isNext, currentPage: currentPage)
        XCTAssertEqual(1, currentPage)
    }
    
    func testPriviousButton_2To1() {
        let isNext = false
        var currentPage = 2
        currentPage = nextAndPreviousButtonView!.updateCurrentPage(isNext: isNext, currentPage: currentPage)
        XCTAssertEqual(1, currentPage)
    }
    
    func testPriviousButton_0To2() {
        let isNext = false
        var currentPage = 0
        currentPage = nextAndPreviousButtonView!.updateCurrentPage(isNext: isNext, currentPage: currentPage)
        XCTAssertEqual(2, currentPage)
    }
}
