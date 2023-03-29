import { Post } from './../interface/post';
import { CustomResponse } from './../interface/custom-response';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError, Observable, tap, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class PostService {
  private readonly apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  posts$ = <Observable<CustomResponse>>(
    this.http
      .get<CustomResponse>(`${this.apiUrl}/post/list`)
      .pipe(tap(console.log), catchError(this.handleError))
  );

  save$ = (post: Post) =>
    <Observable<CustomResponse>>(
      this.http
        .post<CustomResponse>(`${this.apiUrl}/post/save`, post)
        .pipe(tap(console.log), catchError(this.handleError))
    );

  delete$ = (postId: number) =>
    <Observable<CustomResponse>>(
      this.http
        .delete<CustomResponse>(`${this.apiUrl}/server/delete/${postId}`)
        .pipe(tap(console.log), catchError(this.handleError))
    );

  handleError(error: HttpErrorResponse): Observable<never> {
    console.log(error);
    return throwError(`An error occured - Error code: ${error}`);
  }
}
