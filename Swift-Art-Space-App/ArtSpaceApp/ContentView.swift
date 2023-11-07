//
//  ContentView.swift
//  ArtSpaceApp
//
//  Created by Jaehwa Noh on 11/6/23.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        MyGallary()
    }
}

struct MyGallary: View {
    var body: some View {
        VStack(alignment: .center) {
            MyPicture()
            PictureArtistAndName()
            NextAndPreviousButton()
        }
    }
}

struct MyPicture: View {
    var body: some View {
        VStack(alignment: .leading) {
            Image("puppy")
                .resizable()
                .scaledToFit()
                .frame(maxWidth: .infinity, maxHeight: 400)
                .background(Color.white)
                .shadow(radius: 10)
            Text("From: ")
        }
        .padding(20)
    }
}

struct PictureArtistAndName: View {
    var body: some View {
        Text("")
    }
}

struct NextAndPreviousButton: View {
    var body: some View {
        Text("")
    }
}

#Preview {
    ContentView()
}
